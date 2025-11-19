class Solution {
    public boolean isAnagram(String s, String t) {
        // THOUGHT PROCESS:
        // Input is lowercase letters only — use fixed-size int[26] for counts (fast, low memory).
        // Increment for s and decrement for t; if all zeros they are anagrams.
        // Time O(n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. If lengths differ return false
        // 2. For each position i:
        //   - increment count for s[i]
        //   - decrement count for t[i]
        // 3. If any count is non-zero return false
        // 4. Otherwise return true

        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // map 'a'..'z' to 0..25 and increment
            count[t.charAt(i) - 'a']--; // decrement for the other string
        }

        for (int c : count) {
            if (c != 0) return false; // mismatch found
        }
        return true;
    }
}

/* BRUTE FORCE (kept for reference)
 - Build frequency maps for both strings and compare them.
 - Time O(n) Space O(k) (k = distinct chars)

import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            countS.put(cs, countS.getOrDefault(cs, 0) + 1);
            countT.put(ct, countT.getOrDefault(ct, 0) + 1);
        }
        return countS.equals(countT);
    }
}
*/