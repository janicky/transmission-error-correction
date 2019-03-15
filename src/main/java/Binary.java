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
        int sum = 0, i = 0;
        for (boolean b : word) {
            sum += Math.pow(2, i++);
        }
        return sum;
    }

    public static boolean toBoolean(int value) {
        return value == '1' ? true : false;
    }

    public static boolean[] toBooleanArray(char input) {
        boolean[] word = new boolean[8];

        int i = 0;
        for (char b : Integer.toBinaryString(input).toCharArray()) {
            word[i++] = Binary.toBoolean(b);
        }
        return word;
    }
}
