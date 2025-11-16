class Solution {
    // THOUGHT PROCESS:
    // Start from the ocean edges and flood inward: run DFS from the Pacific edges and from the Atlantic edges.
    // Cells reached by both searches can flow to both oceans.
    // Time: O(ROWS*COLS). Space: O(ROWS*COLS) for visited arrays and recursion.
    private int ROWS, COLS;

    // PSEUDOCODE:
    // 1. Prepare two visited maps: pacific and atlantic.
    // 2. Run DFS from all Pacific border cells (top row and left column).
    // 3. Run DFS from all Atlantic border cells (bottom row and right column).
    // 4. Collect cells visited by both searches and return their coordinates.
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        // visited maps for both oceans
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        // start DFS from Pacific borders: top row and left column
        for (int c = 0; c < COLS; c++) dfs(0, c, pac, heights, heights[0][c]);
        for (int r = 0; r < ROWS; r++) dfs(r, 0, pac, heights, heights[r][0]);

        // start DFS from Atlantic borders: bottom row and right column
        for (int c = 0; c < COLS; c++) dfs(ROWS - 1, c, atl, heights, heights[ROWS - 1][c]);
        for (int r = 0; r < ROWS; r++) dfs(r, COLS - 1, atl, heights, heights[r][COLS - 1]);

        // collect cells that can reach both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    // DFS that moves from lower/equal height to higher/equal neighbors (reverse flow)
    private void dfs(int r, int c, boolean[][] visited, int[][] heights, int prevHeight) {
        // stop if out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;
        // stop if already visited
        if (visited[r][c]) return;
        // stop if current cell is lower than previous (can't flow uphill)
        if (heights[r][c] < prevHeight) return;

        // if we reach here, mark cell as visited
        visited[r][c] = true;

        // explore 4 neighbors
        dfs(r + 1, c, visited, heights, heights[r][c]);
        dfs(r - 1, c, visited, heights, heights[r][c]);
        dfs(r, c + 1, visited, heights, heights[r][c]);
        dfs(r, c - 1, visited, heights, heights[r][c]);
    }
}
