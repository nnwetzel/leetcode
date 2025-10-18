class Solution {
    public int firstUniqChar(String s) {
        // THOUGHT PROCESS:
        // HashMap approach to count character frequencies - O(n) time, O(1) space
        // Pseudocode:
        // 1. Count frequency of each character using HashMap
        // 2. Iterate through string again to find first character with count 1
        // 3. Return index of that character, or -1 if none found
        
        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();

        // Count frequency of each character
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Find first character that appears only once
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}