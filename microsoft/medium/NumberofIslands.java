class Solution {
    public int numIslands(char[][] grid) {
        // THOUGHT PROCESS:
        // DFS approach to find connected components - O(m*n) time, O(m*n) space
        // Pseudocode:
        // 1. Iterate through each cell in the grid
        // 2. When we find a '1', increment island count
        // 3. Use DFS to mark all connected '1's as '0' (visited)
        // 4. This ensures each island is counted only once
        
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;       // Number of rows
        int nc = grid[0].length;    // Number of columns
        int numIslands = 0;
        
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;           // Found new island
                    dfs(grid, r, c);        // Go through entire island and make all parts '0'
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;       // Number of rows
        int nc = grid[0].length;    // Number of columns

        // Base cases: out of bounds or already visited/water
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // Mark current cell as visited - if it's part of the island, make it '0'
        grid[r][c] = '0';
        
        // Explore all 4 adjacent cells (up, down, left, right)
        dfs(grid, r - 1, c);  // up
        dfs(grid, r + 1, c);  // down
        dfs(grid, r, c - 1);  // left
        dfs(grid, r, c + 1);  // right
    }
}