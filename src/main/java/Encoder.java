public class Encoder {
    public boolean[] encode(char word) {
        boolean[] binary = Binary.toBooleanArray(word);

        boolean[] encoded = new boolean[Constants.MATRIX[0].length];
        for (int i = 0; i < Constants.LENGTH; i++) {
            encoded[i] = binary[i];
            encoded[Constants.LENGTH + i] = Binary.toBoolean(Binary.sumBinaryRow(binary, i, Constants.LENGTH) % 2);
        }
        return encoded;
    }
}
