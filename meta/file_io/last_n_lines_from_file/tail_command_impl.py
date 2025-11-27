"""
Print last N lines from a file.
"""

from collections import deque

# Time: O(N) - read entire file
# Space: O(N) - storing last n lines
def tail(filename, n):
    # initialize a deque with maxlen n to store last n lines
    last_lines = deque(maxlen=n)

    try:
        with open(filename, 'r') as f:
            for line in f:
                # append each line to the deque (without trailing newline)
                last_lines.append(line.rstrip("\n"))
        # print each line in the deque
        for line in last_lines:
            print(line)
    except FileNotFoundError:
        print(f"Error: {filename} not found")