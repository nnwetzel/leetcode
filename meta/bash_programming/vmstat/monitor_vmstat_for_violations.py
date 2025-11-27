"""
Monitor vmstat output for violations of a specified metric.
"""

#!/usr/bin/env python3
import sys
import time
from collections import deque

# Time: O(N) - single pass through input
# Space: O(M) - storing violation timestamps, M = max violations in window
def monitor(metric, limit, count, window):
    # convert limit, count, window to integers because they come in as strings
    limit = int(limit)
    count = int(count)
    window = int(window)

    # --- 1) Read until we find the header row ---
    for line in sys.stdin:
        line = line.strip()
        if line.startswith("procs"):
            # read the next line (the actual header row) and split it into a list of column names
            header = next(sys.stdin).strip().split()
            break

    # find column index of the given metric
    metric_idx = header.index(metric)

    # --- 2) Track timestamps when metric exceeded limit ---
    violations = deque()

    # --- 3) Process each data row to detect violations ---
    for line in sys.stdin:
        line = line.strip()
        # skip empty lines
        if not line:
            continue

        # split line into columns
        cols = line.split()
        # find value of the given metric in this line
        value = int(cols[metric_idx])
        now = time.time()

        # remove all violations that happened outside the time window
        # now - oldest violation time = how long it's been since the violation
        while violations and now - violations[0] > window:
            # remove oldest timestamp
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

# Example usage:
# python3 monitor_vmstat_for_violations.py us 80 1 60 < sample_vmstat.txt