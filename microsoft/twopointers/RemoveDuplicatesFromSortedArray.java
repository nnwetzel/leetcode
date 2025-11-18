class Solution {
    // THOUGHT PROCESS:
    // Use two pointers in-place. Keep a write index for the next unique value and scan with a read pointer.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. If array is empty return 0.
    // 2. Set left pointer to 1.
    // 3. For each read index from 1 to end:
    //    - if current value differs from previous, write it at the left pointer and advance left pointer.
    // 4. Return left pointer as new length.

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int l = 1;
        // iterate through array with right pointer
        for (int r = 1; r < nums.length; r++) {
            // when we find a new unique value, write it and advance left pointer
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}

/* BRUTE FORCE SOLUTION (for reference):
public int removeDuplicates(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    int insertIndex = 0;
    
    for (int num : nums) {
        if (!seen.contains(num)) {
            seen.add(num);
            nums[insertIndex++] = num;
        }
    }
    
    return insertIndex;
}
*/