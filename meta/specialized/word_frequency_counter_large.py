"""
Find top K most frequent words in a large file.
"""

from collections import Counter

# MapReduce style word frequency counter for large files
def map_phase(chunk):
    local_count = Counter()
    for line in chunk:
        line = line.lower().strip()
        words = line.split()
        for word in words:
            cleaned = "".join(c for c in word if c.isalnum())
            if cleaned:
                local_count[cleaned] += 1
    return local_count

# Reduce phase to combine local counts
def reduce_phase(counters):
    total_count = Counter()
    for counter in counters:
        total_count.update(counter)
    return total_count

# split the file into chunks
# chunks = [
#     open("words.txt").read().splitlines()[:10],
#     open("words.txt").read().splitlines()[10:20],
#     open("words.txt").read().splitlines()[20:],
# ]

# mapped = [map_phase(chunk) for chunk in chunks]
# reduced = reduce_phase(mapped)

# print(reduced.most_common(10))