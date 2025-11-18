class Solution {
    // THOUGHT PROCESS:
    // Move zeros to the front and twos to the back by swapping as you scan once;
    // ones naturally end up in the middle. Use three pointers:
    // - start: next position to place a zero (everything left of start is zero)
    // - index: current position being examined (start..index-1 are ones)
    // - end: next position to place a two (everything right of end is two)
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Set start = 0, index = 0, end = last index
    // 2. While index is at or before end:
    //   - If value at index is 0:
    //     - swap value at index with value at start
    //     - increase start by 1
    //     - increase index by 1
    //   - Else if value at index is 1:
    //     - increase index by 1
    //   - Else (value at index is 2):
    //     - swap value at index with value at end
    //     - decrease end by 1

    public void sortColors(int[] nums) {
        int start = 0, index = 0, end = nums.length - 1;

        // process until index goes past end; left of start are zeros, right of end are twos
        while (index <= end) {
            if (nums[index] == 0) {
                // put zero to the front
                int tmp = nums[index];
                nums[index] = nums[start];
                nums[start] = tmp;
                start++;
                index++;
            } 
            else if (nums[index] == 1) {
                // one stays in the middle
                index++;
            }
            else {
                // put two to the back and re-check the swapped-in value
                int tmp = nums[index];
                nums[index] = nums[end];
                nums[end] = tmp;
                end--;
            }
        }
    }
}