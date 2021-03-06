import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private Encoder encoder = new Encoder();
    private Decoder decoder = new Decoder();

    @Test
    void noErrors() {
        boolean[] encoded = encoder.encode('A');
        decoder.decode(encoded);
        assertEquals(false, decoder.hasSingleError());
    }

    @Test
    void singleError() {
        boolean[] encoded = encoder.encode('A');
        encoded[8] = !encoded[8];
        char result = decoder.decode(encoded);
        assertEquals(true, decoder.hasSingleError());
        assertEquals('A', result);
    }

    @Test
    void doubleError() {
        boolean[] encoded = encoder.encode('A');
        encoded[6] = !encoded[6];
        encoded[11] = !encoded[11];
        char result = decoder.decode(encoded);
        assertEquals(false, decoder.hasSingleError());
        assertEquals(true, decoder.hasDoubleError());
        assertEquals('A', result);
    }
}