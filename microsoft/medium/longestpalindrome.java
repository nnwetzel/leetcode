class Solution {
    public String longestPalindrome(String s) {
        // THOUGHT PROCESS:
        // Brute force: Check every possible substring for palindrome - O(n³) time
        // Example: For "babad", check "b", "ba", "bab", "baba", "babad", "a", "ab", etc.
        // This is too slow because we check each substring character by character
        //
        // Better: Expand around centers - O(n²) time
        // Pseudocode:
        // 1. For each position, try it as palindrome center
        // 2. Check both odd-length (center at i) and even-length (center between i and i+1)
        // 3. Expand outward while characters match
        // 4. Track the longest palindrome found
        
        // Expand around centers approach - O(n²) time complexity
        // Intuition: Test every position as potential center and expand outward
        // Example: "aba" → try centers at index 0, 1, 2 → longest is "aba" from center 1
        
        int n = s.length();
        int start = 0, end = 0;

        // Test each position as potential palindrome center - O(n) positions
        for (int i = 0; i < n; i++) {
            // Check both odd-length and even-length palindromes
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;  // j=0: odd length, j=1: even length
                
                // Expand outward while characters match - O(n) expansion per center
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                
                // Step back to last valid positions
                left++;
                right--;

                // Update longest palindrome if current is longer
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            }
        }
        
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