import random
import time

SIZE = 500
A = [[random.randint(0, 10) for _ in range(SIZE)] for _ in range(SIZE)]
B = [[random.randint(0, 10) for _ in range(SIZE)] for _ in range(SIZE)]
C = [[0] * SIZE for _ in range(SIZE)]

start = time.time()

for i in range(SIZE):
    for j in range(SIZE):
        for k in range(SIZE):
            C[i][j] += A[i][k] * B[k][j]

end = time.time()

total = sum(sum(row) for row in C)
print(f"Sum of elements: {total}")
print(f"Time taken: {(end - start) * 1000:.2f} ms")
