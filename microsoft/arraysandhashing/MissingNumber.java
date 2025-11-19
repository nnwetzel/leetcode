class Solution {

    // THOUGHT PROCESS:
    // Record all seen numbers in a set, then scan the full range from 0 to n to find the missing value.
    // This returns the single number in [0, n] that does not appear in nums.
    // Time: O(n). Space: O(n).

    // PSEUDOCODE:
    // 1. Put every number from nums into a set
    // 2. For each i from 0 up to nums.length:
    //   - if i is not in the set, return i
    // 3. Return -1 (should not happen for valid input)

    public int missingNumber(int[] nums) {
        // put all numbers into a set for O(1) membership checks
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        // scan the full range 0..n and return the first missing number
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}