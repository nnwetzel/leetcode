class Solution {
    // THOUGHT PROCESS:
    // Find the integer square root by binary searching for the largest integer whose square is not greater than x.
    // Use a long when squaring to avoid overflow.
    // Time: O(log x). Space: O(1).

    // PSEUDOCODE:
    // 1. If x is 0 or 1 return x.
    // 2. Set search range from 1 up to x divided by 2.
    // 3. While the search range is not empty:
    //    - pick the middle value
    //    - square it safely; if it equals x return it
    //    - if the square is less than x remember the middle as a candidate and move the lower bound up
    //    - otherwise move the upper bound down
    // 4. Return the last remembered candidate.

    public int mySqrt(int x) {
        // handle small inputs directly
        if (x < 2) return x;

        int left = 1;
        int right = x / 2;
        int ans = 0;

        // binary search for the floor of sqrt(x)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // cast to long to avoid overflow
            long sq = (long) mid * mid;

            // exact square root found
            if (sq == x) {
                return mid;           
            }
            // mid^2 is less than x, search higher values
            else if (sq < x) {
                ans = mid;           
                left = mid + 1;
            }
            // mid^2 is greater than x, search lower values
            else {
                right = mid - 1;
            }
        }
        // largest integer whose square is <= x
        return ans;
    }
}