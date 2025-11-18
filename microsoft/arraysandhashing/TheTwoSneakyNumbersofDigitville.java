class Solution {
    // THOUGHT:
    // Find the two numbers that appear twice by tracking which numbers we've seen.
    // When a number is seen again record it as a duplicate.
    // Time: O(n). Space: O(n).

    // PSEUDOCODE:
    // 1. Make an empty set called seen and an array result of size two
    // 2. For each number in the input:
    //   - If the number is already in seen, add it to result
    //   - Otherwise add the number to seen
    // 3. Return result
    public int[] getSneakyNumbers(int[] nums) {
        // numbers we've seen so far
        Set<Integer> seen = new HashSet<>();
        int[] res = new int[2];
        int idx = 0;

        for (int num : nums) {
            // try to add; if add returns false the number was already present -> duplicate
            if (seen.contains(num)) {
                // record duplicate
                res[idx++] = num;
                // stop once we found both
                if (idx == 2) break;
            }
            seen.add(num);
        }

        return res;
    }
}