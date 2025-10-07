class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Two-pointer approach after sorting for O(n²) solution
        // Intuition: Fix first element, then use two pointers to find pairs that sum to target
        // Example: [-1,0,1,2,-1,-4] → sorted: [-4,-1,-1,0,1,2] → find triplets that sum to 0
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // Process elements within bounds and stop at positive numbers
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
        // Target: nums[i] + nums[lo] + nums[hi] = 0
        int lo = i + 1;
        int hi = nums.length - 1;

        // Continue while pointers don't meet (when lo == hi, we've checked all pairs)
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];

            if (sum < 0) {
                // Sum too small, move left pointer right to increase sum
                lo++;
            } else if (sum > 0) {
                // Sum too large, move right pointer left to decrease sum
                hi--;
            } else {
                // Found valid triplet, add to result
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));

                // Skip duplicates while lo hasn't crossed hi and current equals previous
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }
}