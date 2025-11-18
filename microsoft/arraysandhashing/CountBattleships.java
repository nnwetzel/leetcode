class Solution {
    public int countBattleships(char[][] board) {
        // THOUGHT PROCESS:
        // Brute force: DFS/BFS to mark visited ship cells - correct but needs extra work
        // Better: Count the "head" of each ship by scanning once
        // Time: O(r*c). Space: O(1)
        // A cell is a ship head if it is 'X' and there is no 'X' directly above or to the left.
        //
        // PSEUDOCODE:
        // 1. Set count to zero
        // 2. For each cell in the board:
        //   - If cell is not 'X' skip
        //   - If cell has an 'X' above skip (it's continuation of a vertical ship)
        //   - If cell has an 'X' to the left skip (it's continuation of a horizontal ship)
        //   - Otherwise increment count
        // 3. Return count

        int ROWS = board.length;
        int COLS = board[0].length;
        int count = 0;

        // scan each cell
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // skip empty cells
                if (board[r][c] != 'X') continue;

                // skip if there's an 'X' above (this cell is part of a vertical ship)
                if (r > 0 && board[r - 1][c] == 'X') continue;

                // skip if there's an 'X' to the left (this cell is part of a horizontal ship)
                if (c > 0 && board[r][c - 1] == 'X') continue;

                // this cell is the head of a ship
                count++;
            }
        }
        return count;
    }
}