class Solution {

    // THOUGHT PROCESS:
    // Greedily subtract the largest Roman values from num and append their symbols until num is zero.
    // For example, for 58: 50 (L) is subtracted first, then 5 (V), then three 1s (III) to form "LVIII".
    // Time: O(1). Space: O(1).

    // PSEUDOCODE:
    // 1. Prepare arrays of values and corresponding symbols, ordered largest to smallest
    // 2. For each value and symbol:
    //   - while num is at least value:
    //     - subtract value from num
    //     - append symbol to the result
    // 3. Return the result string

    public String intToRoman(int num) {
        // values and symbols in descending order to apply the greedy choice
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
        };
        
        StringBuilder sb = new StringBuilder();

        // for each symbol, append it as many times as it fits into num
        for (int i = 0; i < values.length && num > 0; i++) {
            // while we can still subtract this value from num
            while (num >= values[i]) {
                // subtract value and append symbol
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}