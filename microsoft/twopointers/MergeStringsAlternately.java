class Solution {
    public String mergeAlternately(String word1, String word2) {
        // THOUGHT PROCESS:
        // Build the merged string by taking characters alternately from each word
        // Handle differing lengths by appending remaining characters from the longer word
        // Time complexity: O(m + n) time, Space complexity: O(m + n)
        //
        // Pseudocode:
        // 1. Let m be length of word1 and n be length of word2
        // 2. For i from 0 to max(m, n) minus one
        //   - If i is less than m append character from word1
        //   - If i is less than n append character from word2
        // 3. Return the built string

        int m = word1.length();
        int n = word2.length();

        // Use StringBuilder to efficiently build the result
        StringBuilder sb = new StringBuilder();

        // Alternate appending characters from each word and automatically handle leftovers
        for (int i = 0; i < Math.max(n, m); i++) {
            if (i < m) {
                sb.append(word1.charAt(i));
            }
            if (i < n) {
                sb.append(word2.charAt(i));
            }
        }

        // Return the merged string
        return sb.toString();
    }
}