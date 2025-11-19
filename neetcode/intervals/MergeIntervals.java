class Solution {

    // THOUGHT PROCESS:
    // Sort intervals by start, then sweep once keeping a single current interval.
    // If the next interval overlaps, extend the current end; otherwise add current and start a new one.
    // Time: O(n log n) due to sorting. Space: O(n) for output list.

    // PSEUDOCODE:
    // 1. Sort intervals by start
    // 2. Keep a current interval and extend its end while the next interval overlaps
    // 3. When no overlap, add current to result and move to next
    // 4. Return result as array

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // base case: no intervals
        if (n == 0) return new int[0][];

        // sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        // start with the first interval and add it to results
        int[] curr = intervals[0];
        res.add(curr);

        // sweep through intervals
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // if starts before current ends, we have overlap
            // curr: [-----7]
            // next:       [7-----]
            // 7 <= 7 → touching is overlap
            if (start <= curr[1]) {
                // overlap: extend the current interval's end if needed
                curr[1] = Math.max(curr[1], end);
            }
            else {
                // no overlap: move to next interval
                curr = intervals[i];
                res.add(curr);
            }
        }
        // convert list to array and return
        return res.toArray(new int[res.size()][]);
    }
}