class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            count += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}