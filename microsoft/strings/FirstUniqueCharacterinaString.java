class Solution {
    public int firstUniqChar(String s) {
        // THOUGHT PROCESS:
        // HashMap approach to count character frequencies
        // Time: O(n). Space: O(1).
        
        // PSEUDOCODE:
        // 1. Count frequency of each character using HashMap
        // 2. Iterate through string again to find first character with count 1
        // 3. Return index of that character, or -1 if none found
        
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();

        // count frequency of each character
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // find first character that appears only once
        for (int i = 0; i < n; i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}