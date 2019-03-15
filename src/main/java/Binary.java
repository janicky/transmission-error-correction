public class Binary {
    public static boolean[] getBooleanArray(char input) {
        boolean[] word = new boolean[8];

        int i = 0;
        for (char b : Integer.toBinaryString(input).toCharArray()) {
            word[i++] = (b == '1' ? true : false);
        }

        return word;
    }

    public static int toInt(boolean value) {
        return value ? 1 : 0;
    }
}
