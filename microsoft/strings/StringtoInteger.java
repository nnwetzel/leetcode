class Solution {

    // THOUGHT PROCESS:
    // Trim leading spaces, read an optional plus or minus sign, then read digits in order.
    // Build the number one digit at a time and before adding each digit check if doing so
    // would overflow a 32-bit signed integer; if it would, return INT_MAX or INT_MIN.
    // This produces the parsed integer or the clamped boundary value on overflow.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Trim whitespace; if empty return 0
    // 2. Read optional '+' or '-' to determine sign
    // 3. Read digits one by one:
    //   - if adding the next digit would overflow, return INT_MAX or INT_MIN
    //   - otherwise incorporate the digit into the result
    // 4. Return signed result

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int index = 0;
        int sign = 1;

        // handle optional sign
        char first = s.charAt(index);
        if (first == '-') {
            sign = -1;
            index++;
        }
        else if (first == '+') {
            index++;
        }

        int result = 0;
        // while next character is a digit, build the number
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            // get the digit value by subtracting '0' which is 48 in ASCII
            int digit = s.charAt(index) - '0';

            // check for overflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // safe to add digit
            result = result * 10 + digit;
            index++;
        }
        // return final result with sign
        return sign * result;
    }
}