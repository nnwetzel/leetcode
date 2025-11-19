class Solution {

    // THOUGHT PROCESS:
    // Find the smallest integer made only of consecutive set bits (1, 3, 7, 15, ...)
    // that is greater than or equal to n. Start at 1 and keep appending a 1 bit
    // on the right by doing x = x * 2 + 1 until x reaches or exceeds n.
    // Time: O(log n), Space: O(1)

    // PSEUDOCODE:
    // 1. Set x to 1
    // 2. While x is less than n:
    //   - set x to x times two plus one (append a 1 bit)
    // 3. Return x

    public int smallestNumber(int n) {
        // start with the smallest number that has only set bits
        int x = 1;
        // append 1 bits until x >= n
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;
    }
}