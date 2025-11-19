class Solution {
    public boolean checkIfPangram(String sentence) {
        // THOUGHT PROCESS:
        // We need to check if the sentence contains all letters from 'a' to 'z' once.
        // We can use a HashSet to track the unique characters we encounter.
        // Time: O(n) to scan the sentence. Space: O(1) since the set size is capped at 26.

        // PSUEDOCODE:
        // 1. Create HashSet to track unique characters seen
        // 2. Iterate through each character in sentence
        // 3. Add each character to the set (duplicates ignored)
        // 4. Check if set size equals 26 (all lowercase letters)
        
        Set<Character> seen = new HashSet<>();

        // Add each character to set (automatically handles duplicates)
        for (Character c : sentence.toCharArray()) {
            seen.add(c);
        }

        // Pangram has all 26 lowercase letters
        return seen.size() == 26;
    }
}