class Solution {
    public boolean isPalindrome(String s) {
        // THOUGHT PROCESS:
        // Remove non alphanumeric characters and lowercase the rest
        // Then check if the cleaned string reads the same forwards and backwards
        // Time complexity: O(n) time, Space complexity: O(n) space

        // Pseudocode:
        // 1. Build a cleaned string keeping only letters and digits in lowercase
        // 2. Compare the cleaned string with its reverse
        // 3. Return true if they match otherwise false

        // Build cleaned string containing only lowercase alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        // Check palindrome by comparing with reversed cleaned string
        String cleaned = sb.toString();
        String reversed = sb.reverse().toString();
        return cleaned.equals(reversed);
    }
}