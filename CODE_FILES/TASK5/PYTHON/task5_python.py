import time
from concurrent.futures import ThreadPoolExecutor

def count_data_lines(lines):
    return sum(1 for line in lines if 'data' in line)

def main():
    start = time.time()

    with open("input.txt", "r") as f:
        lines = f.readlines()

    chunk_size = len(lines) // 4
    chunks = [lines[i:i + chunk_size] for i in range(0, len(lines), chunk_size)]

    with ThreadPoolExecutor(max_workers=4) as executor:
        results = executor.map(count_data_lines, chunks)

    total = sum(results)
    print("Lines containing 'data':", total)
    print(f"Time taken: {(time.time() - start) * 1000:.2f} ms")
    
    # Adding delay to view process in Process Explorer
    time.sleep(5)

if __name__ == "__main__":
    main()
