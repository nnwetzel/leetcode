class Solution {
    public int characterReplacement(String s, int k) {
        // THOUGHT PROCESS:
        // Use a sliding window and count characters inside it
        // Keep track of the most frequent character in the window
        // If window size minus that frequency is greater than k shrink the window
        //
        // Pseudocode:
        // 1. Create empty map, set left = 0, set maxFreq = 0, set longestLen = 0
        // 2. Move the right pointer from the first character to the last character
        //   - Increase count for character at right and update maxFreq
        //   - While window length minus maxFreq is greater than k
        //     - Decrease count for character at left and move left one step right
        //   - Update longestLen with current window size
        // 3. Return longestLen

        // count maps each character to its frequency inside the current window
        Map<Character, Integer> count = new HashMap<>();
        int longestLen = 0;
        int l = 0;
        // maxFreq is the count of the most frequent character in the current window
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
            // Update most frequent character count seen in the window
            maxFreq = Math.max(maxFreq, count.get(rightChar));

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
// ...existing code...
```// filepath: /Users/nnwetzel/Desktop/Desktop-Main/Projects/leetcode/microsoft/medium/longestsubstringwithoutrepeatingcharacters.java
// ...existing code...
class Solution {
    public int characterReplacement(String s, int k) {
        // THOUGHT PROCESS:
        // Use a sliding window and count characters inside it
        // Keep track of the most frequent character in the window
        // If window size minus that frequency is greater than k shrink the window
        //
        // Pseudocode:
        // 1. Create empty map, set left = 0, set maxFreq = 0, set longestLen = 0
        // 2. For right from 0 to last index
        //   - Increase count for character at right and update maxFreq
        //   - While window length minus maxFreq is greater than k
        //     - Decrease count for character at left and move left one step right
        //   - Update longestLen with current window size
        // 3. Return longestLen

        // count maps each character to its frequency inside the current window
        Map<Character, Integer> count = new HashMap<>();
        int longestLen = 0;
        int l = 0;
        // maxFreq is the count of the most frequent character in the current window
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
            // Update most frequent character count seen in the window
            maxFreq = Math.max(maxFreq, count.get(rightChar));

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