class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            // If the current characters match, move to the next characters
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            // If the abbreviation character is not a digit from '1' to '9', it's invalid
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            // Mark the start of the number in the abbreviation
            int start = j;
            // Move j forward while the current character is a digit
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            // Convert the digit substring into an integer
            int num = Integer.valueOf(abbr.substring(start, j));
            // Skip num characters in the original word
            i += num;
        }

        // Both strings must be fully processed for the abbreviation to be valid
        return i == word.length() && j == abbr.length();
    }
}
