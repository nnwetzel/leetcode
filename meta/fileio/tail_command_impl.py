"""
Print last N lines from a file.
"""

from collections import deque

def tail(filename, n):
    # store only last n lines
    last_lines = deque(maxlen=n)

    try:
        with open(filename, 'r') as f:
            # read file line by line and add to deque which keeps only last n lines
            for line in f:
                last_lines.append(line.rstrip("\n"))
        # print the last n lines
        for line in last_lines:
            print(line)
    except FileNotFoundError:
        print(f"Error: {filename} not found")