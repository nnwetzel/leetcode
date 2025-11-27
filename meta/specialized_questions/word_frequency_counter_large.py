"""
Find top K most frequent words in a large file.
"""

from collections import Counter

# MapReduce style phase: process one chunk of lines and count words
def map_phase(chunk):
    # counter() is a hashmap/dictionary specialized for counting
    local_count = Counter()
    for line in chunk:
        # lowercase and trim whitespace
        line = line.lower().strip()
        # split line into words
        words = line.split()
        for word in words:
            # remove non-alphanumeric characters
            cleaned = "".join(c for c in word if c.isalnum())
            # count word if not empty
            if cleaned:
                local_count[cleaned] += 1
    # return the partial word count for this chunk
    return local_count

# Reduce phase: merge all partial Counters into a single global Counter
def reduce_phase(counters):
    total_count = Counter()

    # add counts from each chunk's Counter into one combined Counter
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