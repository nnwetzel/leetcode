class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // Explain two-pointer strategy: i for word, j for abbr
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            // Justify: exact letter match -> advance both pointers
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }

            // Explain: numbers represent skips; leading '0' is illegal (e.g., "01")
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false; // not a letter match and not a valid number start
            }

            // Justify: parse maximal digit run to form the skip length
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }

            // Note: substring is all digits; Integer.valueOf is safe here
            int num = Integer.valueOf(abbr.substring(start, j));

            // Important boundary check: skip must not overshoot word
            if (i + num > word.length()) {
                return false;
            }

            // Explain: number means "skip num characters" in word (not consume abbr chars)
            i += num;
        }

        // Justify correctness condition: both pointers must finish exactly
        // (prevents leftover letters/digits or incomplete skips)
        return i == word.length() && j == abbr.length();
    }
}