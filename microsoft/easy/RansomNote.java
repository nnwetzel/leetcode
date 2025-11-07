class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // THOUGHT PROCESS:
        // Count letters in the magazine and consume them for the ransom note
        // Time complexity: O(m + n) Space complexity: O(1)
        //
        // PSEUDOCODE:
        // 1. Create empty map available
        // 2. For each character in magazine
        //   - Increment available count for that character
        // 3. For each character in ransom note
        //   - If available count is zero return false
        //   - Otherwise decrement available count
        // 4. Return true

        // available maps each character to how many remain from the magazine
        Map<Character, Integer> available = new HashMap<>();

        // Build counts from magazine
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);
            available.put(m, available.getOrDefault(m, 0) + 1);
        }

        // Try to build ransom note by consuming counts
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            // Left tells how many copies of this letter are still available to use from the magazine
            int left = available.getOrDefault(r, 0);
            if (left == 0) return false;
            available.put(r, left - 1);
        }
        return true;
    }
}