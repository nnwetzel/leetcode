class Solution {
    // THOUGHT PROCESS:
    // Reverse only the vowels by scanning from both ends and swapping vowels everytime a pair is found.
    // Time: O(n). Space: O(n) for the char array.

    // PSEUDOCODE:
    // 1. Make a set of vowel characters and a char array from the string.
    // 2. Set left to the start and right to the end.
    // 3. While left is before right:
    //    - move left forward until it points at a vowel
    //    - move right backward until it points at a vowel
    //    - swap the characters at left and right
    //    - advance left and right pointers
    // 4. Return the new string built from the char array.

    public String reverseVowels(String s) {
        // set of vowel characters for quick checks
        Set<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );

        // work with a mutable array of characters
        char[] chars = s.toCharArray();

        int l = 0, r = chars.length - 1;
        while (l < r) {
            // advance left until a vowel or until pointers cross
            while (l < r && !vowels.contains(chars[l])) l++;
            // move right backward until a vowel or until pointers cross
            while (l < r && !vowels.contains(chars[r])) r--;

            // swap the vowels found at left and right
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            // advance pointers inward
            l++;
            r--;
        }
        return new String(chars);
    }
}