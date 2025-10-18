class Solution {
    public int maxArea(int[] height) {
        // THOUGHT PROCESS:
        // Brute force: Try every pair of lines - O(n²) time
        // This checks all combinations but is too slow for large inputs
        //
        // Better: Two pointer approach - O(n) time, O(1) space
        // Pseudocode:
        // 1. Start with widest container (left=0, right=n-1)
        // 2. Calculate area and update maximum
        // 3. Move pointer with smaller height inward
        // 4. Continue until pointers meet

        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            maxarea = Math.max(maxarea, (length * width));
            
            // Move pointer with smaller height - only way to potentially get larger area
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxarea;
    }
}

/* BRUTE FORCE SOLUTION:
public int maxArea(int[] height) {
    int maxarea = 0;

    for (int left = 0; left < height.length; left++) {
        for (int right = left + 1; right < height.length; right++) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            maxarea = Math.max(maxarea, (length * width));
        }
    }

    return maxarea;
}
*/