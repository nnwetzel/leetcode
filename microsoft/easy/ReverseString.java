class Solution {
    // THOUGHT PROCESS: Reverse in-place by swapping ends using two pointers.
    // Time O(n). Space O(1).

    // PSEUDOCODE:
    // 1. While left pointer is less than right pointer:
    //    - Store left char in temp.
    //    - Set left char to right char.
    //    - Set right char to temp.
    //    - Move left pointer right and right pointer left.
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }
}