
public class Decoder {

    private int firstErrorPosition = -1;
    private boolean hasSingleError = false;

    public char decode(boolean[] word) {
        boolean[] modulo = new boolean[Constants.LENGTH];

        for (int i = 0; i < Constants.LENGTH; i++) {
            modulo[i] = Binary.toBoolean(Binary.sumBinaryRow(word, i, Constants.MATRIX[0].length) % 2);
        }

        hasSingleError = this.singleErrorOccurred(modulo);
        return 'x';
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

    public boolean hasSingleError() {
        return hasSingleError;
    }
}
