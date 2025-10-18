class Solution {
    public int mySqrt(int x) {
        // THOUGHT PROCESS:
        // Binary search approach - O(log x) time, O(1) space
        // Key insight: The square root of x is between 1 and x/2 for x >= 2
        // Reminder: We must round down to the nearest integer (floor of sqrt)
        // Pseudocode:
        // 1. Use binary search to find the largest integer whose square is <= x
        // 2. If mid*mid == x, return mid
        // 3. If mid*mid < x, update answer to mid (mid is a candidate since mid*mid <= x), move left up
        // 4. If mid*mid > x, move right down
        // Example: x=8 → mid=2, sq=4; mid=3, sq=9; answer=2
        
        if (x < 2) {
            return x; // For 0 and 1, return x itself
        }
        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Find middle value
            long sq = (long) mid * mid; // Avoid overflow by casting to long

            if (sq == x) {
                return mid; // Found exact square root
            }
            else if (sq < x) {
                ans = mid;      // mid is a candidate because mid*mid <= x (could be the answer)
                left = mid + 1; // Search higher values
            }
            else {
                right = mid - 1; // mid*mid too large, search lower values
            }
        }
        return ans; // Return the largest integer whose square is <= x (rounded down)
    }
}

/* BRUTE FORCE SOLUTION:
public int mySqrt(int x) {
    // Try every number from 1 up to x/2
    for (int i = 1; i <= x / 2; i++) {
        if (i * i == x) {
            return i; // Found exact square root
        }
        if (i * i > x) {
            return i - 1; // Return previous number if square exceeds x
        }
    }
    return x; // For x = 0 or 1
}
*/