class Solution {
    // THOUGHT PROCESS:
    // Keep a sliding window of characters with no repeats. Expand the window to the right
    // and, when a repeat appears, move the left edge forward until the repeat is removed.
    // Track the largest window seen.
    // Time: O(n). Space: O(min(n, charset)).

    // PSEUDOCODE:
    // 1. Use a set to store characters in the current window.
    // 2. For each character at the right pointer:
    //    - While the character is already in the set, remove the leftmost char and move left forward.
    //    - Add the current character to the set.
    //    - Update maximum length with current window size (right - left + 1).
    // 3. Return maximum length.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0, maxLen = 0;

        // expand window by moving right
        for (int r = 0; r < s.length(); r++) {

            // shrink window from left until c is not in the window
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }

            // include current char and update answer
            seen.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}