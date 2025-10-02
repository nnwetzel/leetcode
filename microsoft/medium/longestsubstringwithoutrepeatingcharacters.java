class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window approach with character index tracking
        // Intuition: Expand window until duplicate found, then shrink from left
        // Example: "pwwkew" → windows: "p"(1), "pw"(2), jump past first 'w' → "w"(1), "wk"(2), "wke"(3), jump past first 'w' → "kew"(3)
        
        Map<Character, Integer> map = new HashMap<>(); // ^character    ^last seen index
        int start = 0, len = 0;
        
        // Process each character while maintaining sliding window
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If character was seen before and is within current window
            if (map.containsKey(c)) {
                // Only move start if duplicate is within current window bounds
                // Prevents moving backwards when duplicate is outside window
                if (map.get(c) >= start) {
                    start = map.get(c) + 1;  // Jump past the previous occurrence
                }
            }
            
            // Update max length with current window size
            // Example: substring from index 2 to 4 has le ngth 4-2+1 = 3
            len = Math.max(len, i - start + 1);
            
            // Record current position of this character for future reference
            map.put(c, i);
        }
        
        return len;
    }
}