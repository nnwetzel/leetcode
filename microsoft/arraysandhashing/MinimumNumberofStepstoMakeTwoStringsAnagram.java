class Solution {

    // THOUGHT PROCESS:
    // Count how many more of each letter s has than t. Each extra letter in s
    // must be created by changing a character in t, so the answer is the sum
    // of positive differences in letter counts.
    // The number of characters that t lacks in order to become an anagram of s.
    // Example: s = "ab", t = "bb"
    //   - after counting: freq['a'] = 1 (s has one more 'a'), freq['b'] = -1 (t has one more 'b')
    //   - sum of positive entries = 1, so one change in t (change a 'b' to 'a') makes an anagram
    // Time: O(n) to count letters. Space: O(1) for fixed-size freq array.

    // PSEUDOCODE:
    // 1. Make an array freq for 26 letters
    // 2. For each char in s: increase its count in freq
    // 3. For each char in t: decrease its count in freq
    // 4. Sum all positive entries in freq and return that sum

    public int minSteps(String s, String t) {
        // letter counts: positive means s has more of that letter
        int[] freq = new int[26];
        
        // count letters in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // subtract letters in t
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        // steps is how many letters s has in excess of t
        int steps = 0;
        for (int x : freq) {
            if (x > 0) steps += x;
        }
        return steps;
    }
}