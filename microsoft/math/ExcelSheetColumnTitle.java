class Solution {
    public String convertToTitle(int columnNumber) {
        // THOUGHTPROCESS:
        // Treat the column number as a base-26 representation with letters A..Z.
        // Because columns are 1-indexed (A = 1, Z = 26), convert to 0-indexed each step
        // by subtracting 1 before taking remainder. Repeat until number is zero.

        // PSEUDOCODE:
        // 1. Set result to empty string builder
        // 2. While column number > 0
        //   - Subtract one from column number to convert to 0-based
        //   - Compute remainder = columnNumber mod 26
        //   - Append character (remainder -> 'A' + remainder) to result
        //   - Divide columnNumber by 26
        // 3. Reverse result and return it

        // Build characters from least significant to most significant
        StringBuilder ans = new StringBuilder();

        // Convert until no digits remain
        while (columnNumber > 0) {
            // Convert to 0-based so that 1 -> 0, 26 -> 25
            columnNumber--;

            // Compute current letter from remainder and append
            ans.append((char) (columnNumber % 26 + 'A'));

            // Move to next "digit"
            columnNumber /= 26;
        }

        // Reverse to get most significant letter first and return
        return ans.reverse().toString();
    }
}