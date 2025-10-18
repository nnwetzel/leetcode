class Solution {
    public int findMinArrowShots(int[][] points) {
        // THOUGHT PROCESS:
        // Greedy approach - O(n log n) time for sorting, O(1) space
        // Key: Always shoot arrows at the end of the current overlapping interval
        // Pseudocode:
        // 1. Sort balloons by their end position
        // 2. Initialize arrows = 1, currArrowEnd = end of first balloon
        // 3. For each balloon:
        //    a. If current start > currArrowEnd, need a new arrow, update currArrowEnd
        //    b. Else, balloon is burst by current arrow
        // 4. Return arrows

        if (points.length == 0) return 0;

        // Sort balloons by their end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currArrowEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            // If current balloon starts after the last arrow's end, shoot a new arrow
            if (start > currArrowEnd) {
                arrows++;
                currArrowEnd = end;
            }
            // Else, current balloon is burst by the previous arrow
        }
        return arrows;
    }
}