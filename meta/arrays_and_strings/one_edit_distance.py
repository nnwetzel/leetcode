"""
Check if two strings are exactly one edit apart.
"""

# Time: O(N) - single pass through both strings
# Space: O(1) - constant space
def isOneDistance(s, t):
    m, n = len(s), len(t)
    # if lengths difference is more than 1, can't be one edit apart
    if abs(m - n) > 1:
        return False
    
    i = j = 0

    # traverse both strings with two pointers
    while i < m and j < n:
        # mismatch found
        if s[i] != t[j]:
            # if equal length, skip both chars
            # example: s="abc", t="adc" → skip 'b' and 'd'.
            if m == n:
                return s[i+1:] == t[j+1:]
            # if s is longer, skip the extra char in s
            # example: s="abc", t="ac" → skip 'b' in s.
            if m > n:
                return s[i+1:] == t[j:]
            # if t is longer, skip the extra char in t
            # example: s="ac", t="abc" → skip 'b' in t.
            if m < n:
                return s[i:] == t[j+1:]
    # if no mismatches found, they are one edit apart only if lengths differ by 1
    # example: s="abc", t="ab" → one deletion at end.
    return abs(m - n) == 1