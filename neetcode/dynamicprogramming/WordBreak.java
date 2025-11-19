import java.util.*;

class Solution {
    // THOUGHT PROCESS:
    // Use a boolean table dp where dp[i] is true when the first i characters of s
    // can be built from words in the dictionary. Start with dp[0] = true (empty).
    // Keep the dictionary in a set so you can quickly check "is this substring a word?"

    // PSEUDOCODE:
    // - Put words into a set.
    // - dp[0] = true.
    // - For each end position:
    //   * For each start before end:
    //     - If dp[start] is true and the substring from start to end is in the dictionary,
    //       set dp[end] to true and stop checking this end.
    // - Return dp at the full string length.

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        // dictionary for quick "is this a word?" checks
        Set<String> dict = new HashSet<>(wordDict);

        // dp[i] means first i characters can be formed
        boolean[] dp = new boolean[n + 1];
        // empty prefix is always formable
        dp[0] = true; 

        // build up which prefixes are formable
        for (int end = 1; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                // if the left prefix can be formed and the right part is a dictionary word,
                // then the prefix up to end can be formed
                if (dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    // no need to try other splits for this end
                    break;
                }
            }
        }

        // dp[n] tells if the whole string can be formed
        return dp[n];
    }
}