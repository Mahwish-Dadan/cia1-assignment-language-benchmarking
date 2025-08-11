import time

start = time.time()
count = 0

with open("input.txt", "r", encoding="utf-8") as f:
    for line in f:
        if "data" in line:
            count += 1

end = time.time()
print("Lines containing 'data':", count)
print(f"Time taken: {end - start:.4f} seconds")
