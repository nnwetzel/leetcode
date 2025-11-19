class Solution {
    public int search(int[] nums, int target) {
        // THOUGHT PROCESS:
        // Search a rotated sorted array for the target using a modified binary search
        // At each step determine which side is normally ordered and narrow the search to the side that can contain the target
        // We check which side is ordered because only one half is sorted in a rotated array, so that tells us where the target could be
        // Time O(log n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Set left to the first index and right to the last index
        // 2. While there are elements to consider
        //   - Pick the middle index between left and right
        //   - If the middle element is the target return its index
        //   - If the left to middle segment is in order
        //     - If the target lies between left and middle search the left half
        //     - Otherwise search the right half
        //   - Otherwise the middle to right segment is in order
        //     - If the target lies between middle and right search the right half
        //     - Otherwise search the left half
        // 3. If not found return -1

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;

            // If left to mid is normally ordered
            if (nums[l] <= nums[m]) {
                // If target is inside the ordered left half search it
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                }
                else {
                    // Otherwise search the right half
                    l = m + 1;
                }
            } 
            // Otherwise mid to right is ordered
            else {

                // If target is inside the ordered right half search it
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                }
                else {
                    // Otherwise search the left half
                    r = m - 1;
                }
            }
        }
        return -1; // target not found
    }
}