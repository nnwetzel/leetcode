class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Take first two points to define the line
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        // Compute slope components (rise, run) once
        int dx = x1 - x0;
        int dy = y1 - y0;

        // Check if every other point lies on this line
        for (int[] coord : coordinates) {
            int x = coord[0], y = coord[1];

            // Cross multiplication avoids floating point division
            // Ensures (y - y1)/(x - x1) == dy/dx without divide-by-zero
            if (dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }
        return true;
    }
}