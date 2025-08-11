import random

line_with_data = "This is a log entry with the word data.\n"
line_without_data = "This is just another log line.\n"

with open("input.txt", "w") as f:
    while f.tell() < 10_000_000:  # 10 MB target
        line = line_with_data if random.random() < 0.3 else line_without_data
        f.write(line)
