import random
import time
import bisect

# Generate data
data = [random.randint(0, 1_000_000) for _ in range(1_000_000)]

start = time.time()

data.sort()
found = 0

for _ in range(1000):
    target = random.randint(0, 1_000_000)
    index = bisect.bisect_left(data, target)
    if index < len(data) and data[index] == target:
        found += 1

end = time.time()

print(f"Found {found} values.")
print(f"Time taken: {(end - start) * 1000:.2f} ms")
