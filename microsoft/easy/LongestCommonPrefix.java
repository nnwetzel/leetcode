class Solution {
    public String longestCommonPrefix(String[] strs) {
        // THOUGHT PROCESS:
        // Brute force compares characters across all pairs which is verbose
        // Better shrink candidate prefix by scanning each string once
        // Time complexity O(n * m) where n is number of strings and m is average length
        // Space complexity O(1)
        //
        // Pseudocode:
        // 1. If input is empty return empty string
        // 2. Set prefix to the first string
        // 3. For each remaining string
        //   - While the string does not start with prefix
        //     - Remove last character from prefix
        //     - If prefix becomes empty return empty string
        // 4. Return prefix

        // Handle empty input
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the candidate prefix
        String prefix = strs[0];

        // Compare and shrink prefix against each subsequent string
        for (int i = 1; i < strs.length; i++) {
            // While current string does not start with prefix shorten prefix
            while (!strs[i].startsWith(prefix)) {
                // Remove last character from prefix to try a shorter candidate
                prefix = prefix.substring(0, prefix.length() - 1);
                // If nothing left then no common prefix exists
                if (prefix.isEmpty()) return "";
            }
        }
        // Remaining prefix is the longest common prefix
        return prefix;
    }
}