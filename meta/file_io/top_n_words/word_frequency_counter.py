"""
Find top n most frequent words in a large file.
"""

from collections import Counter
import heapq
import string

def top_n_words(file_name, n):
    # counter() is a hashmap/dictionary specialized for counting
    word_count = Counter()

    with open(file_name, 'r') as f:
        for line in f:
            words = line.lower().split()
            for word in words:
                # remove punctuation from the word
                cleaned = word.strip(string.punctuation)
                # count word if not empty
                if cleaned:
                    word_count[cleaned] += 1

    # use a heap to find the n largest frequencies
    # n is the number of largest elements to return
    # word_count.items() is the iterable to search
    # key=lambda x: x[1] specifies to sort by frequency
    top_words = heapq.nlargest(n, word_count.items(), key=lambda x: x[1])

    for word, _ in top_words:
        print(word)

top_n_words('words.txt', 2)