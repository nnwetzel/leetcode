class Solution {
    public boolean checkIfPangram(String sentence) {
        // THOUGHT PROCESS:
        // HashSet approach - O(n) time, O(1) space (max 26 characters)
        // Pseudocode:
        // 1. Create HashSet to track unique characters seen
        // 2. Iterate through each character in sentence
        // 3. Add each character to the set (duplicates ignored)
        // 4. Check if set size equals 26 (all lowercase letters)
        
        Set<Character> seen = new HashSet<>();

        // Add each character to set (automatically handles duplicates)
        for (Character currChar : sentence.toCharArray()) {
            seen.add(currChar);
        }

        // Pangram has all 26 lowercase letters
        return seen.size() == 26;
    }
}