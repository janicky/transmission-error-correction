import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @Test
    void toInt() {
        assertEquals(2, Binary.toInt(new boolean[] { true, false }));
        assertEquals(4, Binary.toInt(new boolean[] { true, false, false }));
    }

    @Test
    void toBoolean() {
        assertEquals(false, Binary.toBoolean(0));
        assertEquals(true, Binary.toBoolean(1));
    }

    @Test
    void toBooleanArray() {
        boolean[] expected = { false, true, false, false, false, false, false, true };
        boolean[] result = Binary.toBooleanArray('A');

        assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}