class Solution {
    public int removeElement(int[] nums, int val) {
        // THOUGHT PROCESS:
        // Brute force: For each occurrence of val, shift all later elements left
        // This is correct but does repeated shifting -> O(n^2) time
        // Better: Use two pointers to compact the array in-place -> O(n) time, O(1) space
        // Reader visits every element once; writer overwrites removed values and marks the next write position

        // Psueocode:
        // 1. Set writer to zero
        // 2. For each element from first to last
        //   - If the element equals the value to remove skip it
        //   - Otherwise copy the element to the writer index and increment writer
        // 3. Return writer

        // Writer is the index where the next kept element will be written
        int writer = 0;

        // Reader scans each element left to right
        for (int reader = 0; reader < nums.length; reader++) {
            // If current element equals the value to remove skip it
            if (nums[reader] == val) {
                continue;
            }

            // Copy current element to writer index and advance writer
            nums[writer] = nums[reader];
            writer++;
        }

        // Return the new length; kept elements occupy nums[0..writer-1]
        return writer;
    }
}