class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // THOUGHT PROCESS:
        // Dynamic Programming approach - O(n²) time, O(n) space
        // Pseudocode:
        // 1. Convert wordDict to HashSet for O(1) lookups
        // 2. Create dp array where dp[i] = true if s[0...i-1] can be segmented
        // 3. For each position i, try all possible ways to split the string
        // 4. If left part is segmentable (dp[j] = true) AND right part is dict word: mark as valid
        // 5. Example: "leetcode" = "leet" (valid) + "code" (in dict) = true
        
        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string can always be segmented
        
        // For each position i in the string
        for (int i = 1; i <= n; i++) {
            // Try all possible split points j before position i
            for (int j = 0; j < i; j++) {
                // Check: dp[j] is true (left part segmentable) AND right part is dictionary word
                // Example: i=8, j=4: dp[4] true (can segment "leet") AND "code" in dict → TRUE
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        
        // DP STEP-BY-STEP EXAMPLE: s = "leetcode", wordDict = ["leet", "code"]
        // dp[0] = true (empty string)
        // i=1: "l" - no valid splits → dp[1] = false
        // i=2: "le" - no valid splits → dp[2] = false  
        // i=3: "lee" - no valid splits → dp[3] = false
        // i=4: "leet" - j=0: dp[0]=true + "leet" in dict → dp[4] = true
        // i=5: "leetc" - no valid splits → dp[5] = false
        // i=6: "leetco" - no valid splits → dp[6] = false
        // i=7: "leetcod" - no valid splits → dp[7] = false
        // i=8: "leetcode" - j=4: dp[4]=true + "code" in dict → dp[8] = true
        // Result: dp[8] = true (entire string can be segmented)
    }
}