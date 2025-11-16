class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num); // 3 0 1

        int expectedNumCount = nums.length + 1; // array is missing 1 so the expected length is nums .length + 1
        for (int i = 0; i < expectedNumCount; i++) { // 4 iterations
            if (!numSet.contains(i)) { // if numset does not the i value
                return i; // we have our missig nnum!
            }
        }
        return -1;
    }
}