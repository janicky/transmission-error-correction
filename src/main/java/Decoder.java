
public class Decoder {

    private int firstErrorPosition;
    private boolean hasSingleError;

    public char decode(boolean[] word) {
        clearVariables();

        boolean[] modulo = new boolean[Constants.LENGTH];

        for (int i = 0; i < Constants.LENGTH; i++) {
            modulo[i] = Binary.toBoolean(Binary.sumBinaryRow(word, i, Constants.MATRIX[0].length) % 2);
        }

        hasSingleError = this.singleErrorOccurred(modulo);
        if (hasSingleError) {
            correctSingleError(word);
        }

        boolean[] result = new boolean[Constants.LENGTH];
        System.arraycopy(word, 0, result, 0, Constants.LENGTH);

        return (char) Binary.toInt(result);
    }

    private boolean singleErrorOccurred(boolean[] modulo) {
        for (int i = 0; i < Constants.MATRIX[0].length; i++) {
            boolean same = true;
            for (int j = 0; j < Constants.MATRIX.length; j++) {
                if (Constants.MATRIX[j][i] != modulo[j]) {
                    same = false;
                }
            }
            if (same) {
                firstErrorPosition = i;
                return true;
            }
        }
        return false;
    }

    private void correctSingleError(boolean[] word) {
        if (hasSingleError) {
            word[firstErrorPosition] = !word[firstErrorPosition];
        }
    }

    public boolean hasSingleError() {
        return hasSingleError;
    }

    private void clearVariables() {
        firstErrorPosition = -1;
        hasSingleError = false;
    }
}
