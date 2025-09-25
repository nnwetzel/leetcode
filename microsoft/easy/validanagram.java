class Solution {
    public boolean isAnagram(String s, String t) {
        // Frequency counting approach for O(n) solution
        // Intuition: Anagrams have identical character frequencies
        // Count frequency of each character in both strings and compare
        
        // Early exit if lengths don't match - can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyCount1 = new HashMap<>();
        Map<Character, Integer> frequencyCount2 = new HashMap<>();
        
        // Count character frequencies in first string
        for (int i = 0; i < s.length(); i++) {
            frequencyCount1.put(s.charAt(i), frequencyCount1.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // Count character frequencies in second string
        for (int j = 0; j < t.length(); j++) {
            frequencyCount2.put(t.charAt(j), frequencyCount2.getOrDefault(t.charAt(j), 0) + 1);
        }
        
        // Anagrams have identical frequency maps
        return frequencyCount1.equals(frequencyCount2);
    }
}
