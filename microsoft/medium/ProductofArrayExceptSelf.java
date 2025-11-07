class Solution {
    public int[] productExceptSelf(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force multiply all other elements for each index which is O(n^2)
        // Better compute prefix products and suffix products then combine
        // Time complexity: O(n) time, Space complexity: O(n) extra (left and right arrays)
        //
        // Pseudocode:
        // 1. Create arrays left and right sized n
        // 2. left[i] holds product of all elements left of i
        // 3. right[i] holds product of all elements right of i
        // 4. answer[i] = left[i] * right[i] for each i
        // 5. Return answer

        int n = nums.length;
        int[] answer = new int[n];

        // left[i] will be product of all elements to the left of i
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            // Build prefix product up to but not including nums[i]
            left[i] = left[i - 1] * nums[i - 1];
        }

        // right[i] will be product of all elements to the right of i
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            // Build suffix product starting after nums[i]
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Combine prefix and suffix products to get answer for each index
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}