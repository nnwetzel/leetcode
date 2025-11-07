class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: compare every pair to find repeats -> O(n^2)
        // Better: track numbers we've seen and collect any that appear again -> O(n)
        //
        // PSEUDOCODE:
        // 1. Create empty set seen and empty list res
        // 2. For each number in nums
        // 3.   If number is in seen add it to res
        // 4.   Otherwise add number to seen
        // 5. Return res

        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            // If we've seen this number before it's a duplicate -> add to result
            if (seen.contains(num)) {
                res.add(num);
            } else {
                // First time seeing this number -> record it
                seen.add(num);
            }
        }
        return res;
    }
}