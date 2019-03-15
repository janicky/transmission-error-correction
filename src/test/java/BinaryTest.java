import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @Test
    void toInt() {
        assertEquals(2, Binary.toInt(new boolean[] { true, false }));
        assertEquals(4, Binary.toInt(new boolean[] { true, false, false }));
    }
}