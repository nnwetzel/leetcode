class Solution {

    // THOUGHT PROCESS:
    // Use bitwise XOR: duplicate numbers cancel each other, leaving the unique number.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Set x to zero
    // 2. For each number in the array:
    //   - xor x with the number
    // 3. Return x

    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num; // duplicates cancel, result is the single number
        }
        return x;
    }
}