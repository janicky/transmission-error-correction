import java.io.*;

public class Main {
    public static void main(String[] args) {
        File input = new File("data/input.txt");
        File transitional = new File("data/transitional.txt");
        File output = new File("data/output.txt");

        System.out.println("Input: " + input.getAbsolutePath());
        System.out.println("Transitional: " + transitional.getAbsolutePath());
        System.out.println("Output: " + output.getAbsolutePath());

        encodeInput(input, transitional);
        decodeTransitional(transitional, output);
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

            fis.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Can't open input or transitional file.");
        }
    }

    public static void decodeTransitional(File transitional, File output) {
        try {
            FileInputStream fis = new FileInputStream(transitional);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
//            Create file if doesn't exists
            output.createNewFile();
            FileOutputStream fos = new FileOutputStream(output);

            Decoder decoder = new Decoder();

            String line = reader.readLine();
            while (line != null) {
                char word = decoder.decode(Binary.toBooleanArray(line));
                fos.write(word);
                line = reader.readLine();
            }

            fis.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Can't open transitional file or save output file.");
        }
    }
}
