class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // First two points
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        // Slope components (rise and run)
        int dx = x1 - x0;
        int dy = y1 - y0;

        // Check every point against the line formed by the first two points
        for (int[] coord : coordinates) {
            int x = coord[0], y = coord[1];
            // Cross-multiply to compare slopes (avoids dividing by 0 for vertical lines)
            if (dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }
        return true;
    }
}