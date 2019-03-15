public class Constants {

//    Hamming matrix
    public static final boolean[][] MATRIX = new boolean[][]{
            {false, false, false, true, true, false, true, true, true, false, false, false, false, false, false, false},
            {false, false, true, true, false, true, false, true, false, true, false, false, false, false, false, false},
            {false, true, true, false, true, false, false, true, false, false, true, false, false, false, false, false},
            {false, true, false, true, false, true, true, false, false, false, false, true, false, false, false, false},
            {true, false, true, false, true, false, true, false, false, false, false, false, true, false, false, false},
            {true, true, false, false, true, true, false, false, false, false, false, false, false, true, false, false},
            {true, true, true, true, false, false, false, false, false, false, false, false, false, false, true, false},
            {true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, true}
    };
//    Word length
    public static final int LENGTH = 8;
}
