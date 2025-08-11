use std::fs::File;
use std::io::{BufRead, BufReader};
use std::time::Instant;

fn main() {
    let start = Instant::now();
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let mut count = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        if line.contains("data") {
            count += 1;
        }
    }

    println!("Lines containing 'data': {}", count);
    println!("Time taken: {:?}", start.elapsed());

    std::thread::sleep(std::time::Duration::from_secs(3)); // to Keep process open for profiling

}
