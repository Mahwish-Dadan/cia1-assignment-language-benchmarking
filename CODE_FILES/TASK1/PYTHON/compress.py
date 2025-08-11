import gzip
import time

start = time.time()

with open("input.txt", "rb") as f_in:
    with gzip.open("outputpy.txt.gz", "wb") as f_out:
        f_out.writelines(f_in)

end = time.time()
print(f"Time taken: {end - start:.4f} seconds")
