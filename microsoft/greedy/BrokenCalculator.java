class Solution {
    public int brokenCalc(int startValue, int target) {
        // THOUGHT PROCESS:
        // Work backwards from target to startValue using greedy approach.
        // Why? Forward creates too many paths, backward has one optimal path.
        // Time: O(log target). Space: O(1).
        // 
        // PSEUDOCODE:
        // 1. Reduce target until target ≤ startValue
        // 2. If odd: +1, if even: ÷2
        // 3. Fill remaining gap with subtraction
        
        int steps = 0;
        
        while (target > startValue) {
            steps++;
            // if target is odd, previous step must have been +1
            if (target % 2 == 1) {
                target++;
            }
            // if target is even, previous step could have been ×2
            else {
                target /= 2;
            }
        }
        
        // fill remaining gap with subtraction
        return steps + startValue - target;
    }
}