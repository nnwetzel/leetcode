class Solution {
    public String longestPalindrome(String s) {
        // Expand around centers approach for O(n²) solution
        // Intuition: Test every position as potential center and expand outward
        // Example: "aba" → try centers at index 0, 1, 2 → longest is "aba" from center 1
        
        int n = s.length();
        int start = 0, end = 0;

        // Test each position as a potential palindrome center
        for (int i = 0; i < n; i++) {
            // Check both odd-length (center at i) and even-length (center between i and i+1)
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;  // j=0: odd length, j=1: even length
                
                // Expand outward while characters match and stay in bounds
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                
                // Step back to last valid palindrome positions
                left++;
                right--;

                // Update longest palindrome if current one is longer
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}