"""
Find top K most frequent words in a large file.
"""

from collections import Counter
import heapq

def top_k_words(file_name, k):
    # counter() is a hashmap/dictionary specialized for counting
    word_count = Counter()

    with open(file_name, 'r') as f:
        for line in f:
            # lowercase and trim whitespace
            line = line.lower().strip()
            # split line into words
            words = line.split()
            for word in words:
                # remove non-alphanumeric characters
                cleaned = "".join(c for c in word if c.isalnum())
                # count word if not empty
                if cleaned:
                    word_count[cleaned] += 1

    # get top k using heap
    # k is the number of largest elements to return
    # word_count.items() is the iterable to search
    # key=lambda x: x[1] specifies to sort by frequency
    print (word_count.items())
    return heapq.nlargest(k, word_count.items(), key=lambda x: x[1])

# print(top_k_words('words.txt', 2))
top_k_words('words.txt', 10)