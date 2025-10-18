class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: Try all triplets with 3 nested loops - O(n³) time
        // Example: Check [nums[0],nums[1],nums[2]], [nums[0],nums[1],nums[3]], etc.
        // This is too slow for large inputs
        //
        // Better approach: Sort + Two pointers - O(n²) time
        // Pseudocode:
        // 1. Sort array to enable two-pointer technique
        // 2. For each element as first number:
        //    - Use two pointers to find pairs that complete the triplet
        //    - Skip duplicates to avoid duplicate results
        
        // Two-pointer approach after sorting - O(n²) time complexity
        // Intuition: Fix first element, then use two pointers to find pairs that sum to target
        // Example: [-1,0,1,2,-1,-4] → sorted: [-4,-1,-1,0,1,2] → find triplets that sum to 0
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // Process elements and stop at positive numbers - O(n) iterations
        // If nums[i] > 0, all remaining elements are positive, so sum can't equal 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // Skip duplicates for first element to avoid duplicate triplets
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }

    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        // Two-pointer technique to find pairs that sum with nums[i] to equal 0
        int lo = i + 1;
        int hi = nums.length - 1;

        // Continue while pointers don't meet - O(n) per call
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];

            if (sum < 0) {
                lo++;  // Sum too small, move left pointer right
            } else if (sum > 0) {
                hi--;  // Sum too large, move right pointer left
            } else {
                // Found valid triplet
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));

                // Skip duplicates while pointers are valid
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }
}

/* BRUTE FORCE SOLUTION (for reference):
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                // Found triplet, but need to handle duplicates
            }
        }
    }
}
*/