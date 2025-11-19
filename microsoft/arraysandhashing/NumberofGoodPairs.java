class Solution {

    // THOUGHT PROCESS:
    // Count how many earlier occurrences of each value we've seen. Each time we see
    // a value again, it forms that many new good pairs with previous identical values.
    // Time: O(n). Space: O(n).

    // PSEUDOCODE:
    // 1. Make an empty map called freq and set result to zero
    // 2. For each number in the array:
    //   - add the current count for that number to result (these are new pairs)
    //   - increment the count for that number
    // 3. Return result

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            // number of new good pairs equals how many times we've seen num before
            count += freq.getOrDefault(num, 0);
            // record this occurrence for future pairs
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}