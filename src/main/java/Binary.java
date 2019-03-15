public class Binary {
    private boolean[] word;

    public Binary(char word) {
        this.word = new boolean[8];

        int i = 0;
        for (char b : Integer.toBinaryString(word).toCharArray()) {
            this.word[i++] = (b == '1' ? true : false);
        }
    }

    public boolean[] getBooleanArray() {
        return this.word;
    }
}
