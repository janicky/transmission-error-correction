import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @Test
    void toStringTest() {
        boolean[] word = new boolean[] { false, false, true, true, false, true };
        assertEquals("001101", Binary.toString(word));
    }

    @Test
    void toIntTest() {
        assertEquals(2, Binary.toInt(new boolean[] { true, false }));
        assertEquals(4, Binary.toInt(new boolean[] { true, false, false }));
        assertEquals(1, Binary.toInt(true));
        assertEquals(0, Binary.toInt(false));
    }

    @Test
    void toBooleanTest() {
        assertEquals(false, Binary.toBoolean(0));
        assertEquals(true, Binary.toBoolean(1));
        assertEquals(false, Binary.toBoolean('0'));
        assertEquals(true, Binary.toBoolean('1'));
    }

    @Test
    void toBooleanArrayTest() {
        boolean[] expected = { false, true, false, false, false, false, false, true };
        boolean[] result = Binary.toBooleanArray('A');

        assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}