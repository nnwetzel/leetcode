class Solution {

    // THOUGHT PROCESS:
    // Build a one-to-one mapping from characters in s to characters in t.
    // If a character in s is already mapped, it must map to the same character in t.
    // If a character in t is already used in the mapping, we cannot map another character
    // from s to it.
    // Return false if any of these conditions are violated.
    // Time: O(n). Space: O(n).

    // PSEUDOCODE:
    // 1. If lengths differ return false
    // 2. Create an empty forward map and an empty set for used target chars
    // 3. For each position:
    //   - if source char already maps, check it maps to target char
    //   - else if target char is already used return false
    //   - else record the mapping and mark target as used
    // 4. Return true

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // s -> t mapping
        Map<Character, Character> map = new HashMap<>();
        // t chars already mapped-to
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                // existing mapping must match current target char
                if (map.get(a) != b) return false;
            }
            else {
                // cannot map two different source chars to the same target char
                if (used.contains(b)) return false;
                map.put(a, b);    // record new mapping
                used.add(b);      // mark target char as used
            }
        }
        return true;
    }
}