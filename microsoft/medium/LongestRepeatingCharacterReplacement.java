import java.util.Map;
import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        // THOUGHT PROCESS:
        // Use a sliding window and count characters inside it
        // Keep track of the most frequent character in the window
        // If window size minus that frequency is more than k we must shrink the window
        // This finds the longest window that can become all one char with at most k replacements
        //
        // PSEUDOCODE:
        // 1. Create empty map, set left = 0, set maxFreq = 0, set longestLen = 0
        // 2. For right from 0 to last index
        // 3.   Increase count for char at right and update maxFreq
        // 4.   While window size minus maxFreq is greater than k
        // 5.     Decrease count for char at left and move left one step right
        // 6.   Update longestLen with current window size
        // 7. Return longestLen

        Map<Character, Integer> count = new HashMap<>();
        int longestLen = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);
            // Update most frequent character count seen in the window
            maxFreq = Math.max(maxFreq, count.get(c));

            // If we need more than k replacements to make all chars equal, shrink window
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                count.put(leftChar, count.get(leftChar) - 1);
                l++;
            }

            // Record current window size
            longestLen = Math.max(longestLen, r - l + 1);
        }
        return longestLen;
    }
}