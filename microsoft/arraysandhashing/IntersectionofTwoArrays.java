class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // THOUGHT PROCESS:
        // Use a HashSet to track elements in nums1 and check if elements in nums2 exist in that set.
        // If they exist in both, add to result list and remove from set to avoid duplicates.
        // Time: O(n + m). Space: O(n).

        // PSEUDOCODE:
        // 1. Put all elements from nums1 into a HashSet
        // 2. For each element in nums2, check if it exists in the set
        // 3. If found: add to result and remove from set (to avoid duplicates)
        // 4. Convert result list to array and return

        List<Integer> intersection = new ArrayList<>();
        Set<Integer> setA = new HashSet<>();

        // mark values occurring in nums1
        for (int x : nums1) {
            setA.add(x);
        }

        // check if elements in nums2 exist in nums1
        for (int y : nums2) {
            if (setA.contains(y)) {
                intersection.add(y);
                // remove to avoid duplicate intersections
                setA.remove(y);
            }
        }

        // convert ArrayList to array
        int[] out = new int[intersection.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = intersection.get(i);
        }

        return out;
    }
}