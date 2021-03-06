public class Binary {
    public static final String toString(boolean[] word) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : word) {
            sb.append(Binary.toInt(b));
        }
        return sb.toString();
    }

    public static int toInt(boolean value) {
        return value ? 1 : 0;
    }

    public static int toInt(boolean[] word) {
        int sum = 0;
        int j = 0;
        for (int i = word.length - 1; i >= 0; i--) {
            sum += Binary.toInt(word[i]) * Math.pow(2, j++);
        }
        return sum;
    }

    public static boolean toBoolean(int value) {
        return value == 1;
    }

    public static boolean toBoolean(char value) {
        return value == '1';
    }

    public static boolean[] toBooleanArray(char input) {
        boolean[] word = new boolean[Constants.LENGTH];

        int i = 0;
        String binaryString = Integer.toBinaryString(input);
        int shift = Constants.LENGTH - binaryString.length();
        for (char b : binaryString.toCharArray()) {
            word[shift + i++] = Binary.toBoolean(b);
        }
        return word;
    }

    public static boolean[] toBooleanArray(String input) {
        boolean[] output = new boolean[input.length()];
        char[] chars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            output[i] = (chars[i] == '1' ? true : false);
        }

        return output;
    }

    public static int sumBinaryRow(boolean[] word, int row, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Binary.toInt(word[i] && Constants.MATRIX[row][i]);
        }
        return sum;
    }
}
