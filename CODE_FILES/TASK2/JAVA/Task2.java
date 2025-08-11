import java.io.*;
import java.nio.file.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        int count = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("data")) {
                    count++;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Lines containing 'data': " + count);
        System.out.println("Time taken: " + (end - start) + " ms");

	try {
    		Thread.sleep(3000); // sleep for 3 seconds
	} catch (InterruptedException e) {
    		e.printStackTrace();
	}
    }
}
