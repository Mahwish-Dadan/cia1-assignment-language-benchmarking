import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

public class task5_java {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(new File("input.txt").toPath());
        int chunkSize = lines.size() / 4;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int from = i * chunkSize;
            int to = (i == 3) ? lines.size() : (i + 1) * chunkSize;
            List<String> chunk = lines.subList(from, to);
            futures.add(executor.submit(() -> chunk.stream().filter(l -> l.contains("data")).count()));
        }

        long total = 0;
        for (Future<Long> f : futures) total += f.get();

        executor.shutdown();
        System.out.println("Lines containing 'data': " + total);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}
