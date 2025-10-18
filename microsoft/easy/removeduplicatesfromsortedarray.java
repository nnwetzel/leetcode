class Solution {
    public int removeDuplicates(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: Use HashSet to track seen elements - O(n) time, O(n) space
        // This works but uses extra space for the set
        //
        // Better: Two pointer approach - O(n) time, O(1) space
        // Pseudocode:
        // 1. Use insertIndex to track position for next unique element
        // 2. Compare each element with previous element
        // 3. If different: place at insertIndex and increment
        // 4. Return final insertIndex as new length
        
        // Since array is sorted, duplicates are adjacent
        int insertIndex = 1;
        
        // Start from index 1 since first element is always unique
        for (int i = 1; i < nums.length; i++) {
            // Found a new unique element (different from previous)
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        // Return length of array with unique elements
        return insertIndex;
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