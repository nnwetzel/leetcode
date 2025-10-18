class Solution {
    public int singleNonDuplicate(int[] nums) {
        // THOUGHT PROCESS:
        // Binary search - O(log n) time, O(1) space
        // Key insight: Before single element, pairs are at (even, odd) indices
        // After single element: pairs shift to (odd, even) indices
        // Pseudocode:
        // 1. Binary search by checking pairs at even indices
        // 2. If pair is valid: single element is to the right
        // 3. If pair is broken: single element is to the left or at current position
        // Example: [1,1,2,3,3,4,4] → mid=2: nums[2]=2, nums[3]=3 → broken pair → go left
        // Example: [1,1,2,2,3,4,4] → mid=2: nums[2]=2, nums[3]=2 → valid pair → go right
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Make mid even to check pairs consistently
            if (mid % 2 == 1) {
                mid--;
            }

            // If this pair is valid, single element is to the right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;  // Skip this pair, search right
            } else {
                right = mid;     // Single element is here or to the left
            }
        }

        return nums[left];
    }
}

/* BRUTE FORCE SOLUTION:
public int singleNonDuplicate(int[] nums) {
    for (int i = 0; i < nums.length - 1; i += 2) {
        if (nums[i] != nums[i + 1]) {
            return nums[i];
        }
    }
    return nums[nums.length - 1];
}
*/