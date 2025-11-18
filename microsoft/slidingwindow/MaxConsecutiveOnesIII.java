class Solution {
    // THOUGHT PROCESS:
    // Use a sliding window that allows up to k zeros. Expand the right edge, count zeros,
    // and move the left edge forward when zeros exceed k. Track the widest valid window.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Start with left at zero, zero count zero, best zero.
    // 2. For each right index:
    //    - if the element at right is zero increment zero count.
    //    - while zero count is greater than k, move left forward and decrement zero count if that element was zero.
    //    - update best as the window width (right minus left plus one).
    // 3. Return best.
    public int longestOnes(int[] nums, int k) {
        int l = 0;             // left edge of window
        int zeroes = 0;        // number of zeros in current window
        int best = 0;          // best window size found

        for (int r = 0; r < nums.length; r++) {
            // include num at right pointer in window
            if (nums[r] == 0) zeroes++;

            // shrink window until it's valid (zeroes less than/equal to k)
            while (zeroes > k) {
                if (nums[l] == 0) zeroes--;
                l++;
            }

            // current window [l..r] is valid, update best
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}