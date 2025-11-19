class Solution {
    /*
    THOUGHT PROCESS:
    Every palindrome has a center. For each index try two centers (single char and between chars)
    and expand outward while characters match; count each palindrome found.
    Time: O(n^2). Space: O(1).

    PSEUDOCODE:
    1. For each position in the string:
       - Try a center at the character (odd length) and between this and the next (even length).
    2. For each center, expand left and right while characters match and count each match.
    3. Return the total count.
    */

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // try every character as a center
        for (int i = 0; i < n; i++) {
            // j = 0 (odd-length center at i)
            // j = 1 (even-length center between i and i+1)
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;

                // expand while the two ends match
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    // found one palindrome (current l..r)
                    count++;
                    l--;
                    r++;
                }
            }
        }

        return count;
    }
}
