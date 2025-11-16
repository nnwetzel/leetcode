class Solution {
    // THOUGHT (simple):
    // Create pairs that cancel each other: 1 and -1, 2 and -2, etc.
    // Keep adding pairs until we have used up the slots. If n is odd, put 0 in the last slot.
    // Time: O(n). Space: O(n).
    
    // PSEUDOCODE:
    // 1. Make an array of size n.
    // 2. For i from 1 up to n/2, add i and -i.
    // 3. If n is odd, add 0.
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = 0;

        // add pairs: each loop adds a positive and its negative
        for (int i = 1; i <= n / 2; i++) {
            ans[idx++] = i;
            ans[idx++] = -i;
        }

        // if n is odd, place 0 in the remaining slot
        if (n % 2 == 1) ans[idx] = 0;

        return ans;
    }
}