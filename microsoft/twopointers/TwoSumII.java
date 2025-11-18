class Solution {
    // THOUGHT PROCESS:
    // Use two pointers because the array is sorted.
    // Move left right to increase sum, move right left to decrease sum.
    // Time complexity: O(n). Space complexity: O(1).
    //
    // PSEUDOCODE:
    // 1. Set left to 0 and right to last index.
    // 2. While left < right:
    //    - Compute sum of numbers at left and right.
    //    - If sum equals target return 1-based indices.
    //    - If sum less than target move left right by one.
    //    - Otherwise move right left by one.
    // 3. Return empty if not found.

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;                      // left pointer starts at beginning
        int r = numbers.length - 1;     // right pointer starts at end

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            // Found the pair; return 1-based indices as required
            if (sum == target) {
                return new int[] { l + 1, r + 1 };
            }
            // Sum too small: move left pointer right to increase sum
            else if (sum < target) {
                l++;
            }
            // Sum too large: move right pointer left to decrease sum
            else {
                r--;
            }
        }

        // No valid pair found
        return new int[0];
    }
}