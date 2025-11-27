"""
Check if two strings are exactly one edit apart.
"""

# Time: O(N) - single pass through both strings
# Space: O(1) - constant space
def isOneDistance(s1, s2):
    m, n = len(s1), len(s2)

    # if lengths difference is more than 1, can't be one edit apart
    if abs(m - n) > 1:
        return False
    
    edits = 0
    i = j = 0

    # traverse both strings with two pointers
    while i < m and j < n:
        if s1[i] != s2[j]:
            # if we've already seen an edit, a second mismatch means false
            if edits == 1:
                return False
            edits += 1

            # if s1 is longer, skip the extra char in s1
            # example: s1="abc", s2="ac" → skip 'b' in s1.
            if m > n:
                i += 1
            # if s2 is longer, skip the extra char in s2
            # example: s1="ac", s2="abc" → skip 'b' in s2.
            elif m < n:
                j += 1
            # if equal length, skip both chars
            # example: s1="abc", s2="adc" → skip 'b' and 'd'.
            else:
                i += 1
                j += 1
        else:
            # characters match, advance both pointers
            i += 1
            j += 1

    # if one string has one extra character at the end, count it as one edit
    if i < m or j < n:
        edits += 1

    return edits == 1