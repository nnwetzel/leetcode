"""
Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.
"""

from typing import List

# Time: O(N) - single pass through s with a sliding window
# Space: O(1) - character count dictionaries have at most 26 entries (assuming lowercase letters)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # base case
        if len(s) < len(p):
            return []

        result = []
        p_count = {}
        window_count = {}

        # count characters in p and the first window of s
        for ch in p:
            p_count[ch] = p_count.get(ch, 0) + 1
        for ch in s[:len(p)]:
            window_count[ch] = window_count.get(ch, 0) + 1

        # if initial window matches, record index 0
        if window_count == p_count:
            result.append(0)

        # slide the window over s
        for i in range(len(p), len(s)):
            # include new char on the right
            new_ch = s[i]
            window_count[new_ch] = window_count.get(new_ch, 0) + 1

            # remove old char on the left
            old_ch = s[i - len(p)]
            window_count[old_ch] -= 1
            if window_count[old_ch] == 0:
                del window_count[old_ch]

            # if counts match, record start index
            if window_count == p_count:
                result.append(i - len(p) + 1)

        return result