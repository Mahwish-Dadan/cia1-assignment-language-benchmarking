use rand::Rng;
use std::time::Instant;

fn main() {
    let mut rng = rand::thread_rng();
    let mut data: Vec<i32> = (0..1_000_000).map(|_| rng.gen_range(0..=1_000_000)).collect();

    let start = Instant::now();

    data.sort_unstable();
    let mut found = 0;

    for _ in 0..1000 {
        let target = rng.gen_range(0..=1_000_000);
        if data.binary_search(&target).is_ok() {
            found += 1;
        }
    }

    let duration = start.elapsed();
    println!("Found {} values.", found);
    println!("Time taken: {} ms", duration.as_millis());
    
    std::thread::sleep(std::time::Duration::from_secs(3)); // to Keep process open for profiling
}
