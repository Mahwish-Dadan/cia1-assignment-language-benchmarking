import java.util.Random;

public class task4_java {
    public static void main(String[] args) {
        int SIZE = 500;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C = new int[SIZE][SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                A[i][j] = rand.nextInt(11);
                B[i][j] = rand.nextInt(11);
            }
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        long end = System.currentTimeMillis();

        long total = 0;
        for (int[] row : C)
            for (int val : row)
                total += val;

        System.out.println("Sum of elements: " + total);
        System.out.println("Time taken: " + (end - start) + " ms");

	//adding wait time for profiling
	try {
    		Thread.sleep(3000); // sleep for 3 seconds
	} catch (InterruptedException e) {
    		e.printStackTrace();
	}

    }
}
