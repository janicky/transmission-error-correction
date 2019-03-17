
public class Decoder {

    private int firstErrorPosition;
    private int secondErrorPosition;
    private boolean hasSingleError;
    private boolean hasDoubleError;

    public char decode(boolean[] word) {
        clearVariables();

        boolean[] modulo = new boolean[Constants.LENGTH];

        for (int i = 0; i < Constants.LENGTH; i++) {
            modulo[i] = Binary.toBoolean(Binary.sumBinaryRow(word, i, Constants.MATRIX[0].length) % 2);
        }

        hasSingleError = singleErrorOccurred(modulo);
        if (hasSingleError) {
            correctSingleError(word);
        } else {
            hasDoubleError = doubleErrorOcurred(modulo);
            if (hasDoubleError) {
                correctDoubleError(word);
            }
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

    private boolean doubleErrorOcurred(boolean[] modulo) {
        for (int i = 0; i < Constants.MATRIX[0].length; i++) {
            for (int j = 0; j < Constants.MATRIX[0].length; j++) {
                if (j > i) {
                    boolean same = true;
                    for (int k = 0; k < Constants.MATRIX.length; k++) {
                        if (Constants.MATRIX[k][i] ^ Constants.MATRIX[k][j] != modulo[k]) {
                            same = false;
                        }
                    }
                    if (same) {
                        firstErrorPosition = i;
                        secondErrorPosition = j;
                        hasDoubleError = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void correctSingleError(boolean[] word) {
        if (hasSingleError || hasDoubleError) {
            word[firstErrorPosition] = !word[firstErrorPosition];
        }
    }

    private void correctDoubleError(boolean[] word) {
        if (hasDoubleError) {
            correctSingleError(word);
            word[secondErrorPosition] = !word[secondErrorPosition];
        }
    }

    public boolean hasSingleError() {
        return hasSingleError;
    }

    public boolean hasDoubleError() {
        return hasDoubleError;
    }

    private void clearVariables() {
        firstErrorPosition = -1;
        secondErrorPosition = -1;
        hasSingleError = false;
        hasDoubleError = false;
    }
}
