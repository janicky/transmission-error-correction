import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL input_url = Main.class.getResource("input.txt");
        File input_file = new File(input_url.getPath());
        encodeInput(input_file);
    }

    public static void encodeInput(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            while (fis.available() > 0) {
                char word = (char) fis.read();
                System.out.print(word);
            }
        } catch (Exception e) {
            System.out.println("Can't read input file.");
        }
    }
}
