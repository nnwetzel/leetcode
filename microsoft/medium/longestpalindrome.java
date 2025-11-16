class Solution {
    public String longestPalindrome(String s) {
        // THOUGHT PROCESS:
        // Expand around each center (single char and between chars) to find the longest palindrome.
        // Time: O(n^2). Space: O(1).
        //
        // PSEUDOCODE:
        // 1. For each index i in the string:
        //    - Try center at i (odd length) and center between i and i+1 (even length).
        // 2. For each center, expand left and right while characters match.
        //    - After expansion, the palindrome is the substring between the last matching left+1 and right-1.
        // 3. Keep the longest start/end seen so far.
        // 4. Return the substring for the longest range.
        int n = s.length();
        int start = 0, end = 0;

        // try every character in the string as a center
        for (int i = 0; i < n; i++) {
            // j = 0 for odd length (example: "aba")
            // j = 1 for even length (example: "abba")
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;

                // expand while characters match and indices are valid
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }

                // after expanding, left and right are one step beyond the palindrome
                left++;
                right--;

                // update longest palindrome if needed
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            }
        }
        // return the longest palindromic substring found
        return s.substring(start, end + 1);
    }
}

/* BRUTE FORCE SOLUTION (for reference):
class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        
        return longest;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
*/