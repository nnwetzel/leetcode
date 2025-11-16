class Solution {
    // THOUGHT PROCESS:
    // Keep a fixed-size sliding window (size k). Maintain its sum and track the largest sum seen.
    // Divide the largest sum by k to get the maximum average.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Sum the first k elements as the current window sum and record it as the max.
    // 2. For each next element: add the new element, remove the element k steps back, update max.
    // 3. Return max divided by k.
    public double findMaxAverage(int[] nums, int k) {
        // initial window sum of first k elements
        double windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += nums[i];
        // best window sum seen so far
        double maxSum = windowSum; 

        // slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // add incoming, remove outgoing
            windowSum += nums[i] - nums[i - k]; 
            // update max if larger
            if (windowSum > maxSum) maxSum = windowSum; 
        }
        // convert best sum to average
        return maxSum / k; 
    }
}