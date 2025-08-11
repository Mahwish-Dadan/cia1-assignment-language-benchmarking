use rand::Rng;
use std::time::Instant;

const SIZE: usize = 500;

fn main() {
    let mut rng = rand::thread_rng();
    let mut a = vec![vec![0; SIZE]; SIZE];
    let mut b = vec![vec![0; SIZE]; SIZE];
    let mut c = vec![vec![0; SIZE]; SIZE];

    for i in 0..SIZE {
        for j in 0..SIZE {
            a[i][j] = rng.gen_range(0..=10);
            b[i][j] = rng.gen_range(0..=10);
        }
    }

    let start = Instant::now();

    for i in 0..SIZE {
        for j in 0..SIZE {
            for k in 0..SIZE {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    let duration = start.elapsed();

    let sum: i64 = c.iter().flatten().map(|&x| x as i64).sum();
    println!("Sum of elements: {}", sum);
    println!("Time taken: {} ms", duration.as_millis());
    
    std::thread::sleep(std::time::Duration::from_secs(3)); // to Keep process open for profiling
}
