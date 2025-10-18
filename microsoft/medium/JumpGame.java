class Solution {
    public boolean canJump(int[] nums) {
        // THOUGHT PROCESS:
        // Greedy approach working backwards - O(n) time, O(1) space
        // Key insight: Work backwards to find if we can reach each position
        // Pseudocode:
        // 1. Start from the last position (our target)
        // 2. Work backwards, checking if current position can reach our target
        // 3. If yes, update target to current position (we can reach end from here)
        // 4. Check if we can reach position 0 (start)
        
        int lastPos = nums.length - 1;  // Start from the end position
        
        // Work backwards through the array
        for (int i = nums.length - 1; i >= 0; i--) {
            // Check if current position i reaches our target lastPos
            // i + nums[i] = furthest position we can reach from position i
            if (i + nums[i] >= lastPos) {
                lastPos = i;  // Update target to current position
            }
        }
        
        // Return true if we reach the start position
        return lastPos == 0;
    }
}

/* DYNAMIC PROGRAMMING APPROACH:
enum Index {
    GOOD,    // Position reaches the end
    BAD,     // Position does not reach the end
    UNKNOWN  // Haven't determined yet
}

public boolean canJump(int[] nums) {
    Index[] memo = new Index[nums.length];
    
    // Initialize all positions as unknown
    for (int i = 0; i < memo.length; i++) {
        memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD; // Last position is always good
    
    // Work backwards from second-to-last position
    for (int i = nums.length - 2; i >= 0; i--) {
        // Calculate furthest position reachable from i
        int furthestJump = Math.min(i + nums[i], nums.length - 1);
        
        // Check all positions we jump to from i
        for (int j = i + 1; j <= furthestJump; j++) {
            if (memo[j] == Index.GOOD) {
                memo[i] = Index.GOOD; // Found a path to end
                break;
            }
        }
        // If no good position found, memo[i] remains UNKNOWN (effectively BAD)
    }
    
    return memo[0] == Index.GOOD;
}
*/