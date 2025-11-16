class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // THOUGHT PROCESS:
        // We pick a starting number (the fixed element) then find two other numbers that make the total zero
        // Use two pointers moving inward to find those two numbers in a sorted array
        // Time complexity: O(n^2) Space complexity: O(1) extra
        //
        // Pseudocode:
        // 1. Sort nums
        // 2. For each nstarting number in nums
        // 3.   Skip this number if it's the same as the previous one
        // 4.   Set left to the element after the current number and right to the last element
        // 5.   While left pointer is less than right pointer
        //      - Compute the total of the three numbers
        //      - If the total equals 0 add the triplet and move both pointers inward
        //      - If the total is less than 0 move left one step right
        //      - If the total is greater than 0 move right one step left

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Skip duplicate starting numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];

                // Total equals 0 -> found a triplet
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // Move both pointers inward
                    l++;
                    r--;
                    // Skip duplicates for the second and third numbers
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                // Total is less than 0 -> need a larger sum
                else if (total < 0) {
                    l++;
                }
                // Total is greater than 0 -> need a smaller sum
                else if (total > 0) {
                    r--;
                }
            }
        }
        return res;
    }
}