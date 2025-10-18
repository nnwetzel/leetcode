class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // THOUGHT PROCESS:
        // Brute force: Change every pixel and check neighbors recursively - O(m*n) time
        // DFS approach: Only fill connected pixels with the same original color
        // Pseudocode:
        // 1. Store the original color at (sr, sc)
        // 2. If the new color is different, start DFS from (sr, sc)
        // 3. In DFS, for each pixel with the original color:
        //    - Change its color to the new color
        //    - Recursively fill its 4 neighbors (up, down, left, right)
        // 4. Return the modified image

        int prevColor = image[sr][sc];
        if (prevColor != color) { // Only fill if the color is actually changing
            dfs(image, sr, sc, prevColor, color);
        }
        return image;
    }

    public void dfs(int[][] image, int r, int c, int prevColor, int color) {
        // If the current pixel matches the original color, fill it and recurse
        if (image[r][c] == prevColor) {
            image[r][c] = color;
            if (r >= 1) { // Up: protect against going above the top border
                dfs(image, r - 1, c, prevColor, color);
            }
            if (c >= 1) { // Left: protect against going left of the left border
                dfs(image, r, c - 1, prevColor, color);
            }
            if (r < image.length - 1) { // Down: protect against going below the bottom border
                dfs(image, r + 1, c, prevColor, color);
            }
            if (c < image[0].length - 1) { // Right: protect against going past the right border
                dfs(image, r, c + 1, prevColor, color);
            }
        }
    }
}