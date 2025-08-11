import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] data = new int[1_000_000];

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(1_000_001);
        }

        long start = System.currentTimeMillis();

        Arrays.sort(data);
        int found = 0;

        for (int i = 0; i < 1000; i++) {
            int target = rand.nextInt(1_000_001);
            if (Arrays.binarySearch(data, target) >= 0) {
                found++;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("Found " + found + " values.");
        System.out.println("Time taken: " + (end - start) + " ms");

	//adding wait time for profiling
	try {
    		Thread.sleep(3000); // sleep for 3 seconds
	} catch (InterruptedException e) {
    		e.printStackTrace();
	}
    }
}
