import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        File input_file = new File("data/input.txt");
        File transitional_file = new File("data/transitional.txt");

        encodeInput(input_file, transitional_file);
    }

    public static void encodeInput(File input, File transitional) {
        try {
            FileInputStream fis = new FileInputStream(input);
//            Create file if doesn't exists
            transitional.createNewFile();
            FileOutputStream fos = new FileOutputStream(transitional);

            Encoder encoder = new Encoder();

            while (fis.available() > 0) {
                char word = (char) fis.read();
                boolean[] encoded = encoder.encode(word);
                byte[] encoded_bytes = Binary.toString(encoded).getBytes();
                fos.write(encoded_bytes);
                fos.write('\n');
            }

            System.out.println(transitional.getAbsolutePath());

            fis.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Can't open input or transitional file.");
        }
    }
}
