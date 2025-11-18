class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // THOUGHT PROCESS:
        // Brute force: Copy nums2 to end of nums1, then sort - O((m+n) log(m+n)) time
        // This works but doesn't utilize the fact that both arrays are already sorted
        //
        // Better: Three pointer approach from end - O(m+n) time, O(1) space
        // Pseudocode:
        // 1. Start from end of both arrays (largest elements)
        // 2. Compare elements and place larger one at end of nums1
        // 3. Move corresponding pointer backward
        // 4. Continue until all elements from nums2 are merged
        
        // Set p1 and p2 to point to the end of their respective arrays
        int p1 = m - 1;
        int p2 = n - 1;

        // Move p backward through the array, each time writing
        // the largest value pointed at by p1 or p2
        for (int p = m + n - 1; p >= 0; p--) {
            // If nums2 is exhausted, remaining nums1 elements are already in place
            if (p2 < 0) {
                break;
            }
            // Choose larger element between nums1[p1] and nums2[p2]
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            }
            else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}

/* BRUTE FORCE SOLUTION:
public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
}
*/