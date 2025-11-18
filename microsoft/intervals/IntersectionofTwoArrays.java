class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // THOUGHT PROCESS:
        // HashSet approach to find common elements - O(n + m) time, O(n) space
        // Pseudocode:
        // 1. Put all elements from nums1 into a HashSet
        // 2. For each element in nums2, check if it exists in the set
        // 3. If found: add to result and remove from set (to avoid duplicates)
        // 4. Convert result list to array and return

        List<Integer> intersection = new ArrayList<>();
        Set<Integer> setA = new HashSet<>();

        // Mark values occurring in nums1
        for (int x : nums1) {
            setA.add(x);
        }

        // Check if elements in nums2 exist in nums1
        for (int y : nums2) {
            if (setA.contains(y)) {
                intersection.add(y);
                setA.remove(y); // Remove to avoid duplicate intersections
            }
        }

        // Convert ArrayList to array
        int[] results = new int[intersection.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = intersection.get(i);
        }
        
        return results;
    }
}