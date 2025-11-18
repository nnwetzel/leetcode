class Solution {
    // THOUGHT PROCESS:
    // Decide if the integer reads the same forward and backward.
    // Negatives are not palindromes. Numbers ending with 0 are not palindromes unless the number is 0.
    // Instead of reversing the whole number (risk overflow), reverse only half the digits and compare.
    // Time: O(log n). Space: O(1).

    // PSEUDOCODE (plain English):
    // 1 - If x is negative or x ends with 0 but is not 0, return false.
    // 2 - Set rev to zero.
    // 3 - While original part is larger than reversed part:
    //    - take last digit from original and append it to rev
    //    - remove last digit from original
    // 4 - If original equals rev (even digits) or original equals rev without its middle digit (odd digits), return true.

    public boolean isPalindrome(int x) {
        // negative numbers are not palindromes
        // numbers ending with 0 cannot be palindromes unless the number is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        
        int rev = 0;

        // build the reversed half of the number
        while (x > rev) {
            // append last digit of x to rev
            rev = rev * 10 + x % 10;
            // drop the last digit from x
            x /= 10;
        }

        // for even length numbers x == rev.
        // for odd length numbers the middle digit is in rev, so drop it with rev/10.
        return x == rev || x == rev / 10;
    }
}