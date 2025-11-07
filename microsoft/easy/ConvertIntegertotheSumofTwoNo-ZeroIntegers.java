class Solution {
    public int[] getNoZeroIntegers(int n) {
        // THOUGHT PROCESS:
        // Find two positive numbers that add to n and do not contain the digit zero
        // Try each possible first number a and check the partner b = n minus a
        // Time complexity O(n times digit check), space complexity O(1)
        //
        // Pseudocode:
        // 1. Try a from one to n minus one
        // 2. Let b be n minus a
        // 3. If neither a nor b contains digit zero return a and b
        // 4. Return empty array as fallback

        // Try each possible first number a
        for (int a = 1; a < n; a++) {
            // b is the partner number so that a plus b equals n
            int b = n - a;

            // If both numbers have no zero digit return them
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")) {
                return new int[] {a, b};
            }
        }

        // Fallback return
        return new int[0];
    }
}