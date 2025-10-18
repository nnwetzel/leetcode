class Solution {
    public boolean isAnagram(String s, String t) {
        // Frequency counting approach - O(n) time, O(1) space
        // Intuition: Anagrams have identical character frequencies
        // Example: "anagram" and "nagaram" → both have same char counts
        
        // Early exit if lengths don't match
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyCount1 = new HashMap<>();
        Map<Character, Integer> frequencyCount2 = new HashMap<>();
        
        // Count character frequencies in both strings - O(n) iterations
        for (int i = 0; i < s.length(); i++) {
            frequencyCount1.put(s.charAt(i), frequencyCount1.getOrDefault(s.charAt(i), 0) + 1);
            frequencyCount2.put(t.charAt(i), frequencyCount2.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        // Anagrams have identical frequency maps
        return frequencyCount1.equals(frequencyCount2);
    }
}
