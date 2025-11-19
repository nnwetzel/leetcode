class Solution {

    // THOUGHT PROCESS:
    // Keep a running prefix sum. For each prefix, the number of subarrays ending here with sum k
    // equals how many earlier prefixes had value (prefix - k). Track counts of prefix sums in a map.
    // Time: O(n). Space: O(n).

    // PSEUDOCODE:
    // 1. Create map freq and set freq[0] = 1
    // 2. Set prefix = 0 and count = 0
    // 3. For each number in nums:
    //   - add number to prefix
    //   - add freq[prefix - k] to count
    //   - increment freq[prefix]
    // 4. Return count

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        // empty prefix count because sum of zero before starting
        freq.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            // update running prefix sum
            prefix += num;

            // any earlier prefix equal to prefix - k gives a subarray summing to k
            count += freq.getOrDefault(prefix - k, 0);

            // record this prefix sum for future checks
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}