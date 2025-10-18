class Solution {
    public int lengthOfLongestSubstring(String s) {
        // THOUGHT PROCESS:
        // Brute force: Check every possible substring - O(n³) time
        // Example: For "abcabcbb", check "a", "ab", "abc", "abca", "b", "bc", "bca", etc.
        // This is too slow because we check each substring for duplicates
        //
        // Better: Sliding window approach - O(n) time
        // Pseudocode:
        // 1. Use HashMap to track character positions
        // 2. Expand window by moving right pointer
        // 3. When duplicate found: jump left pointer past previous occurrence
        // 4. Track maximum window size seen
        
        // Sliding window approach - O(n) time complexity
        // Intuition: Expand window until duplicate found, then jump past it
        // Example: "pwwkew" → "pw"(2) → jump past first 'w' → "kew"(3)
        
        // HashMap stores character -> last seen index
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, len = 0;
        
        // Single pass through string - O(n) time
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If duplicate found within current window, jump past it
            // Check if character c is a duplicate within the current window:
            // map.containsKey(c): we've seen c before
            // map.get(c) >= start: previous occurrence is inside the current window (not before it)
            // This ensures we only react to duplicates that affect the current substring
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            
            // Update max length: i - start + 1 (0-based to 1-based conversion)
            len = Math.max(len, i - start + 1);
            
            // Record current position for future duplicate checks
            map.put(c, i);
        }
        
        return len;
    }
}

/* BRUTE FORCE SOLUTION (for reference):
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) break;
                seen.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        
        return maxLen;
    }
}
*/