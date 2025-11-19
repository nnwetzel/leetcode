class Solution {

    // THOUGHT PROCESS:
    // Count occurrences of each number in nums1, then for each number in nums2
    // if it still appears in the map add it to the intersection and decrement the count.
    // This preserves duplicates because we only add as many times as the number appears in nums1.
    // Time: O(n + m) where n and m are lengths of nums1 and nums2. Space: O(n) for the frequency map.

    // PSEUDOCODE:
    // 1. Build a frequency map from nums1
    // 2. For each value in nums2:
    //   - If the value's count in the map is positive:
    //     - add the value to the result list
    //     - decrement the value's count in the map
    // 3. Convert result list to int array and return

    public int[] intersect(int[] nums1, int[] nums2) {
        // build frequency map for nums1
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // collect intersection elements, consuming counts so duplicates are handled
        List<Integer> intersection = new ArrayList<>();
        for (int y : nums2) {
            // get the count of y in nums1
            int count = freq.getOrDefault(y, 0);
            // if y appears in nums1, add to intersection and decrement count
            if (count > 0) {
                intersection.add(y);
                freq.put(y, count - 1);
            }
        }

        // convert ArrayList to int[]
        int[] out = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            out[i] = intersection.get(i);
        }
        return out;
    }
}