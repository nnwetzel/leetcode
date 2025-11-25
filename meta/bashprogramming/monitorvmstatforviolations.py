"""
Monitor vmstat output for violations of a specified metric.
"""

#!/usr/bin/env python3
import sys
import time
from collections import deque

def monitor(metric, limit, count, window):
    limit = int(limit)
    count = int(count)
    window = int(window)

    # --- 1) Read until we find the header row ---
    for line in sys.stdin:
        line = line.strip()
        if line.startswith("procs"):
            # read the header row after "procs" and split it into a list of metric names
            header = next(sys.stdin).strip().split()
            break

    # find index of the given metric
    metric_idx = header.index(metric)

    # --- 2) Track timestamps when metric exceeded limit ---
    violations = deque()

    # --- 3) Process each data row ---
    for line in sys.stdin:
        line = line.strip()
        # skip empty lines
        if not line:
            continue

        # split line into list of columns
        cols = line.split()
        # find value for metric
        value = int(cols[metric_idx])
        now = time.time()

        # remove old timestamps outside the window
        while violations and now - violations[0] > window:
            violations.popleft()

        # check if current value exceeds limit
        if value > limit:
            # if so, record violation time
            violations.append(now)
            # check if number of violations meets or exceeds count
            if len(violations) >= count:
                print(f"{metric} > {limit}: {len(violations)} times in last {window} seconds")

if __name__ == "__main__":
    _, metric, limit, count, window = sys.argv
    monitor(metric, limit, count, window)