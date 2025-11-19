class Solution {
    // THOUGHT PROCESS:
    //  - Try each cell as a possible start and do a depth-first search matching characters in order.
    //  - Mark visited cells while exploring and restore them when backtracking.
    //  - Stop exploring a path when out-of-bounds, cell already visited, or character doesn't match.
    //  Time: O(ROWS * COLS * 4^L) in worst case (L = word length). Space: O(L) recursion depth.

    private int ROWS, COLS;

    // PSEUDOCODE:
    // 1. Set ROWS and COLS from the board.
    // 2. For each cell on the board:
    //    - Start DFS from that cell with index 0 of the word.
    //    - If any DFS returns true, the word exists.
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        // try every starting cell
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }
    
    // PSEUDOCODE:
    // 1. If index equals word length, we've matched the whole word so return true.
    // 2. If out of bounds, or cell visited, or cell char != word char -> return false.
    // 3. Mark cell visited, explore 4 neighbors with next index.
    // 4. Restore cell and return whether any neighbor succeeded.
    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        // full match
        if (i == word.length()) return true;

        // out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return false;

        // visited or mismatch
        if (board[r][c] == '#' || word.charAt(i) != board[r][c]) return false;

        // mark visited
        board[r][c] = '#';

        // explore neighbors (down, up, right, left)
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);

        // restore original character (backtrack)
        board[r][c] = word.charAt(i);
        return res;
    }
}
