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
        System.out.println(Binary.toString(encoded));
    }
}