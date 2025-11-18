class Solution {
    // THOUGHT PROCESS:
    // Fill the connected region that has the same color as the start pixel.
    // Change pixels in place so visited pixels are marked by recoloring.
    // Stop when you hit the image boundary or a pixel with a different color.

    // PSEUDOCODE:
    // 1. Read original color at (sr, sc).
    // 2. If original color equals new color, return image.
    // 3. Otherwise call DFS starting at (sr, sc) to recolor the region.
    // 4. Return the image.
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor = image[sr][sc];
        // only fill when the color actually changes
        if (prevColor != color) {
            dfs(image, sr, sc, prevColor, color);
        }
        return image;
    }

    // PSEUDOCODE:
    // 1. If (r,c) is outside image bounds, return.
    // 2. If pixel at (r,c) does not match the original color, return.
    // 3. Set pixel at (r,c) to the new color (marks it visited).
    // 4. Call DFS on (r-1, c), (r+1, c), (r, c-1), (r, c+1)
    public void dfs(int[][] image, int r, int c, int prevColor, int color) {
        // bounds check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        // only process pixels that match the original color
        if (image[r][c] != prevColor) return;

        // paint current pixel
        image[r][c] = color;

        // recurse to four neighbors
        dfs(image, r - 1, c, prevColor, color); // up
        dfs(image, r + 1, c, prevColor, color); // down
        dfs(image, r, c - 1, prevColor, color); // left
        dfs(image, r, c + 1, prevColor, color); // right
    }
}