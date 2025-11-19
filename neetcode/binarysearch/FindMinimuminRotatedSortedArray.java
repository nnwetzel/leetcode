class Solution {
    public int findMin(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: Scan for the first place where a previous element is greater than the current — O(n)
        // Avoid scanning the whole array and use binary search instead

        // Use binary search to find the rotation pivot (smallest value)
        // If the middle value is greater than the right value then the pivot is in the right half
        // Otherwise the pivot is in the left half (including the middle)
        // Time O(log n) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Set left to zero and right to the last index
        // 2. While the search range contains more than one element
        //   - Choose the middle index between left and right
        //   - If the middle value is greater than the right value then move left to one past middle
        //   - Otherwise move right to the middle index
        // 3. Return the element at left

        int l = 0;
        int r = nums.length - 1;

        // Narrow search until one candidate remains
        while (l < r) {
            int m = l + (r - l) / 2; // middle index (avoid overflow)

            // If mid value > right, pivot is to the right
            if (nums[m] > nums[r]) {
                l = m + 1;
            }
            // Else pivot is to the left (including mid)
            else {
                r = m;
            }
        }
        // Left now points to the smallest element
        return nums[l];
    }
}

/* BRUTE FORCE SOLUTION (kept for reference)
 - Scan for first i where nums[i-1] > nums[i]; return nums[i]
 - Time O(n) Space O(1)

public int findMinBruteForce(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
        if (nums[i - 1] > nums[i]) return nums[i];
    }
    return nums[0];
}
*/