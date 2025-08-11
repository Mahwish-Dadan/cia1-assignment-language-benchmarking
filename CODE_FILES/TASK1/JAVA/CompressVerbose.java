import java.io.*;
import java.util.zip.GZIPOutputStream;

public class CompressVerbose {
    public static void main(String[] args) {
        // 1. Start timing
        long start = System.currentTimeMillis();

        // 2. Declare variables outside try block for visibility
        FileInputStream fis = null;
        FileOutputStream fos = null;
        GZIPOutputStream gzip = null;

        try {
            // 3. Open the input file for reading
            fis = new FileInputStream("input.txt");

            // 4. Open the output file for writing compressed data
            fos = new FileOutputStream("output.txt.gz");

            // 5. Wrap the FileOutputStream in a GZIPOutputStream to compress the data
            gzip = new GZIPOutputStream(fos);

            // 6. Create a buffer to hold chunks of data as we read
            byte[] buffer = new byte[1024];

            // 7. Read and write in a loop
            int len = fis.read(buffer); // first read before the loop

            while (len != -1) {
                // 8. Write exactly 'len' bytes from the buffer to the gzip stream
                gzip.write(buffer, 0, len);

                // 9. Read the next chunk into the buffer
                len = fis.read(buffer);
            }

            // Done! All data has been read and written
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 10. Always close the streams in the correct order
            try {
                if (gzip != null) gzip.close();
                if (fos != null) fos.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 11. Stop timing
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}
