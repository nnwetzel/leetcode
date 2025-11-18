class Solution {
    // THOUGHT PROCESS:
    // Reverse the integer by taking digits off the end and appending them to a result.
    // Check for overflow before each append and return zero on overflow.
    // Time: O(number of digits). Space: O(1).

    // PSEUDOCODE:
    // 1. Set rev to zero.
    // 2. Repeat until x is zero:
    //   - get the last digit of x
    //   - remove that last digit from x
    //   - if rev times ten plus the digit would overflow, return zero
    //   - otherwise append the digit to rev by multiplying rev by ten and adding the digit
    // 3. Return rev

    public int reverse(int x) {
        // reversed integer
        int rev = 0;

        while (x != 0) {
            // get last digit
            int digit = x % 10;
            // remove last digit from x
            x /= 10;

            // safe overflow checks before multiplying rev by 10 and adding digit
            // rev > Integer.MAX_VALUE / 10 means rev * 10 would overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // rev < Integer.MIN_VALUE / 10 means rev * 10 would underflow
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev *= 10;
            rev += digit;
        }
        return rev;
    }
}