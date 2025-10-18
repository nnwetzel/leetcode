class Solution {
    public int brokenCalc(int startValue, int target) {
        // THOUGHT PROCESS:
        // Work backwards from target - O(log target) time, O(1) space
        // Why? Forward creates too many paths, backward has one optimal path
        // 
        // Pseudocode:
        // 1. Reduce target until target ≤ startValue
        // 2. If odd: +1, if even: ÷2
        // 3. Fill remaining gap with subtraction
        
        int steps = 0;
        
        while (target > startValue) {
            steps++;
            if (target % 2 == 1) {
                target++;     // Make even
            } else {
                target /= 2;  // Halve it
            }
        }
        
        // Gap: (steps=0 because loop never ran) if startValue=10, target=3 → need 7 subtracts → total = 0 + 7 = 7
        return steps + (startValue - target);
    }
}