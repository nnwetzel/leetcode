class Solution {
    public String reverseWords(String s) {
        // THOUGHT PROCESS:
        // Split and reverse approach - O(n) time, O(n) space
        // Pseudocode:
        // 1. Trim whitespace and split by multiple spaces into words array
        // 2. Iterate through words array backwards
        // 3. Append each word to StringBuilder with spaces between
        // 4. Return the reversed string
        
        // Split by one or more whitespace characters after trimming
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder(s.length());
        
        // Iterate backwards through words array
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            // Add space between words (but not after last word)
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

/* O(1) EXTRA SPACE SOLUTION:
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;

        while (start >= 0) {
            // Find start of current word (move left until non-space)
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            // Append word from start+1 to end+1 with space
            sb.append(s, start + 1, end + 1).append(" ");

            // Skip spaces to find next word
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start; // Update end for next word
        }
        return sb.toString().trim(); // Remove trailing space
    }
}
*/