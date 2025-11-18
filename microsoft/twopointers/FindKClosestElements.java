class Solution {

    // THOUGHT PROCESS:
    // Keep a window of size k and shrink it from the side that is farther from x
    // until the window has size k. The remaining window holds the k closest elements.
    // Time: O(n - k). Space: O(1).

    // PSEUDOCODE:
    // 1. Set left to the start of the array and right to the end.
    // 2. While the current window is larger than k:
    //   - If the left element is farther from x than the right element,
    //     move left forward by one.
    //   - Otherwise move right backward by one.
    // 3. Return the elements from left through right inclusive.

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n - 1;

        // shrink the window until its size is k
        while (r - l + 1 > k) {
            // compare distances to x and remove the farther side
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            } 
            else {
                r--;
            }
        }

        // collect the k elements remaining in the window
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}