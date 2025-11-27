# Time: O(N) - at most one pass through string with helper checks
# Space: O(1) - constant space
class Solution:
    def validPalindrome(self, s: str) -> bool:
        # helper function to check if substring is palindrome
        def is_palindrome(s, left, right):
            while left < right:
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            return True
        
        l, r = 0, len(s) - 1
        
        while l < r:
            # mismatch found
            if s[l] != s[r]:
                # try skipping either end and check palindrome
                # example: "abca" -> skip 'b' or 'c'
                return is_palindrome(s, l + 1, r) or is_palindrome(s, l, r - 1)
            l += 1
            r -= 1
        
        return True