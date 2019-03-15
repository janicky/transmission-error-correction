public class Encoder {
    public boolean[] encode(char word) {
        boolean[] binary = Binary.toBooleanArray(word);
        boolean[][] matrix = Constants.MATRIX;
        System.out.println((int) word);

        boolean[] encoded = new boolean[Constants.MATRIX[0].length];
        for (int i = 0; i < Constants.LENGTH; i++) {
            int sum = 0;
            for (int j = 0; j < Constants.LENGTH; j++) {
                sum += Binary.toInt(binary[j] && matrix[i][j]);
            }
            encoded[i] = binary[i];
            encoded[Constants.LENGTH + i] = Binary.toBoolean(sum % 2);
        }
        return encoded;
    }
}
