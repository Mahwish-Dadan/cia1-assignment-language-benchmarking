use std::fs::File;
use std::io::{BufReader, BufWriter, copy};
use flate2::write::GzEncoder;
use flate2::Compression;
use std::time::Instant;
use std::io::Read;


fn main() {
    let start = Instant::now();

    let input = File::open("input.txt").unwrap();
    let reader = BufReader::new(input);

    let output = File::create("output.txt.gz").unwrap();
    let writer = BufWriter::new(output);

    let mut encoder = GzEncoder::new(writer, Compression::default());
    copy(&mut reader.take(10_000_000), &mut encoder).unwrap();

    encoder.finish().unwrap();

    let duration = start.elapsed();
    println!("Time taken: {:?}", duration);
}
