"""
Check if a given string is a valid palindrome, considering only alphanumeric characters and ignoring cases.
"""

# Time: O(N) - single pass through the string
# Space: O(1) - constant space
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # two pointers
        left, right = 0, len(s) - 1

        # move pointers towards center
        while left < right:
            # skip non-alphanumeric characters
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            
            # return false if mismatch
            if s[left].lower() != s[right].lower():
                return False
            
            # otherwise move inward
            left += 1
            right -= 1

        # return true if all matched
        return True