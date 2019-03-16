import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private Encoder encoder = new Encoder();

    @Test
    void messageNotDamaged() {
        Decoder decoder = new Decoder();
        boolean[] encoded = encoder.encode('A');
        decoder.decode(encoded);
        assertEquals(false, decoder.hasSingleError());
    }
}