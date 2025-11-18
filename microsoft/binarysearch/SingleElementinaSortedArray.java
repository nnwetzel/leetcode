class Solution {
    // THOUGHT PROCESS:
    // Pairs appear as (even,odd) or (nums[0], nums[1]) in the array until the single element; after, the pairing shifts.
    // Use binary search on pair boundaries to find where pairing breaks.
    // Time: O(log n). Space: O(1).
    
    // PSEUDOCODE:
    // 1. Binary search on index range.
    // 2. Make mid point to the start of a pair; if pair is intact (even,odd) search right, else search left.
    // 3. Return the remaining index.
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // narrow to single element
        while (l < r) {
            int mid = l + (r - l) / 2;

            // ensure mid points to the first item of a pair (even index)
            if ((mid % 2) == 1) mid--;

            // if pair at mid is intact (mid == mid + 1) the single is to the right
            if (nums[mid] == nums[mid + 1]) {
                // skip this pair and search right
                l = mid + 2;
            }
            // otherwise the single is at mid or to the left
            else {
                r = mid;
            }
        }
        // l now points to the single non-duplicate element
        return nums[l];
    }
}

/* BRUTE FORCE SOLUTION:
public int singleNonDuplicate(int[] nums) {
    for (int i = 0; i < nums.length - 1; i += 2) {
        if (nums[i] != nums[i + 1]) {
            return nums[i];
        }
    }
    return nums[nums.length - 1];
}
*/