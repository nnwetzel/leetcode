class Solution {
    // THOUGHT PROCESS:
    // Walk the matrix in layers using four boundaries (top, bottom, left, right).
    // Traverse the top row left-to-right, right column top-to-bottom, bottom row right-to-left,
    // and left column bottom-to-top, shrinking the corresponding boundary after each pass.

    // PSEUDOCODE:
    // 1. Initialize top, bottom, left, right to the matrix edges and an empty result list
    // 2. While top <= bottom and left <= right:
    //   - traverse the top row from left to right, then increase top
    //   - traverse the right column from top to bottom, then decrease right
    //   - if a bottom row remains, traverse it from right to left, then decrease bottom
    //   - if a left column remains, traverse it from bottom to top, then increase left
    // 3. Return the result list

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        // process outer layers inward
        while (top <= bottom && left <= right) {
            // left -> right on the top row
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++; // shrink top boundary

            // top -> bottom on the right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // shrink right boundary

            // right -> left on the bottom row (only if a row remains)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--; // shrink bottom boundary
            }

            // bottom -> top on the left column (only if a column remains)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++; // shrink left boundary
            }
        }
        return res;
    }
}
