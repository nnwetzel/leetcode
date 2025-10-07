class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window approach with character index tracking
        // Intuition: Expand window until duplicate found, then jump past it
        // Example: "pwwkew" → "pw"(2) → jump past first 'w' → "kew"(3)
        
        // HashMap stores character -> last seen index
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, len = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If duplicate found within current window
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;  // Jump past previous occurrence
            }
            
            // Update max length: i - start + 1 (0-based to 1-based conversion)
            len = Math.max(len, i - start + 1);
            
            // Record current position
            map.put(c, i);
        }
        
        return len;
    }
}