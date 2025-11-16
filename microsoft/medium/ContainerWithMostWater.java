class Solution {
    // THOUGHT PROCESS:
    // Use two pointers at the ends to calculate the widest container and move the pointer
    // at the shorter line inward. Only moving the shorter line can possibly increase area.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Put left pointer at start and right pointer at end.
    // 2. Before pointers meet:
    //    - compute area with current pointers and update best.
    //    - move the pointer at the shorter line inward.
    // 3. Return the best area found.
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        // move pointers toward each other
        while (l < r) {
            int width = r - l;
            int length = Math.min(height[l], height[r]);
            // calculate and update best area
            max = Math.max(max, width * length);

            // move the pointer at the shorter line to try for a taller container
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }
}