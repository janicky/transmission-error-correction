
public class Decoder {

    private int firstErrorPosition = -1;

    public String decode(boolean[] word) {
        boolean[][] matrix = Constants.MATRIX;
        boolean[] modulo = new boolean[Constants.LENGTH];

        for (int i = 0; i < Constants.LENGTH; i++) {
            modulo[i] = Binary.toBoolean(Binary.sumBinaryRow(word, i) % 2);
        }

        return "to do";
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
                this.firstErrorPosition = i;
                return true;
            }
        }
        return false;
    }
}
