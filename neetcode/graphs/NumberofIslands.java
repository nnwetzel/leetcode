class Solution {

    private int ROWS, COLS;

    public int numIslands(char[][] grid) {
        // THOUGHT PROCESS:
        // DFS approach to find connected components.
        // Mark visited land as '0' while exploring so we don't count it twice.
        // Time: O(m*n). Space: O(m*n) where m,n are grid dimensions.

        // PSEUDOCODE:
        // 1. Keep track of island count.
        // 2. For each cell (row r, column c) in the grid:
        //    - If the cell is '1' (land):
        //      - Increment island count.
        //      - Run a DFS to mark the whole connected island as visited.
        // 3. Return island count.
        
        if (grid == null || grid.length == 0) return 0;

        ROWS = grid.length;
        COLS = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    // found new island
                    numIslands++;
                    // go through entire island and make all connected parts '0'
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    // PSEUDOCODE:
    // 1. If the position is outside the grid or the cell is '0', stop.
    // 2. Mark the current cell as visited by setting it to '0'.
    // 3. Recursively visit the four neighbors (up, down, left, right).
    public void dfs(char[][] grid, int r, int c) {

        // Base case: out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;
        // Base case: already visited or water
        if (grid[r][c] == '0') return;

        // Mark current cell as visited - if it's part of the island, make it '0'
        grid[r][c] = '0';
        
        // Explore all 4 adjacent cells (up, down, left, right)
        dfs(grid, r - 1, c);  // up
        dfs(grid, r + 1, c);  // down
        dfs(grid, r, c - 1);  // left
        dfs(grid, r, c + 1);  // right
    }
}