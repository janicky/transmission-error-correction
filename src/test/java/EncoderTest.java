import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private Encoder encoder;

    @BeforeEach
    void initialize() {
        this.encoder = new Encoder();
    }

    @Test
    void encodingTest() {
        boolean[] encoded = this.encoder.encode('A');
        assertEquals("0100000111010110", Binary.toString(encoded));
    }
}