class Solution {
    public int trap(int[] height) {
        // THOUGHT PROCESS:
        // Two pointers approach - O(n) time, O(1) space
        // Key insight: Water trapped at each position is limited by the shorter wall on either side.
        // Always process the side with lower height, since it determines the water level.
        // Example: [0,1,0,2] → leftMax/rightMax grow, water trapped at index 2 is min(1,2)-0 = 1
        // Pseudocode:
        // 1. Use two pointers from both ends moving towards center
        // 2. Track leftMax and rightMax as we move inward
        // 3. Move pointer with smaller height
        // 4. Add trapped water = max height so far - current height
        // 5. Continue until pointers meet
        
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        
        while (left < right) {
            // Process the side with lower height (water level is determined by the shorter side)
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];  // Add trapped water
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];  // Add trapped water
                right--;
            }
        }
        return ans;
    }
}