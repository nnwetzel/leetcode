class Solution {
    public int longestSubarray(int[] nums) {
        // THOUGHT PROCESS:
        // Sliding window that may contain at most one zero
        // Window length after deleting one element is right - left
        // Time O(n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Set left = 0, zeroes = 0, best = 0
        // 2. For right from 0 to last index
        //   - If nums[right] is zero increment zeroes
        //   - While zeroes > 1 if nums[left] is zero decrement zeroes then left++
        //   - Update best with right - left
        // 3. Return best

        int l = 0;
        int zeroes = 0;
        int best = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeroes++;
            while (zeroes > 1) {
                if (nums[l] == 0) zeroes--;
                l++;
            }
            best = Math.max(best, r - l);
        }
        return best;
    }
}