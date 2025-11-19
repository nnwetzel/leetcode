class Solution {
    public boolean canJump(int[] nums) {
        // THOUGHT PROCESS:
        // Greedy approach working backwards
        // Key insight: Work backwards to find if we can reach each position
        // Time: O(n). Space: O(1).

        // PSEUDOCODE:
        // 1. Start from the last position (our target)
        // 2. Work backwards, checking if current position can reach our target
        // 3. If yes, update target to current position (we can reach end from here)
        // 4. Check if we can reach position 0 (start)
        
        int lastPos = nums.length - 1;  // start from the end position
        
        // work backwards through the array
        for (int i = nums.length - 1; i >= 0; i--) {
            // check if current position i reaches our target lastPos
            // i + nums[i] = furthest position we can reach from position i
            if (i + nums[i] >= lastPos) {
                // update target to current position
                lastPos = i;
            }
        }

        // return true if we reach the start position
        return lastPos == 0;
    }
}