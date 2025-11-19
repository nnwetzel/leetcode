class Solution {

    // THOUGHT PROCESS:
    // Greedily keep intervals that finish earliest to maximize space for later intervals and thus minimize removals.
    // This works because among any overlapping set choosing the earliest-finishing interval never reduces future choices and can be swapped into any optimal solution.
    // Time: O(n log n) due to sorting. Space: O(1).

    // PSEUDOCODE:
    // 1. If there are no intervals return 0
    // 2. Sort intervals by their end time
    // 3. Set removals to 0 and prevEnd to the end of the first interval
    // 4. For each remaining interval:
    //   - If the interval starts before prevEnd:
    //     - increment removals
    //   - Else:
    //     - set prevEnd to this interval's end
    // 5. Return removals

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        // sort by interval end so we keep intervals that finish earliest
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // prevEnd will track end of last kept interval
        int removals = 0;
        int prevEnd = intervals[0][1];

        // scan and count intervals that overlap the last kept interval
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // if interval starts before prevEnd, we have overlap
            if (start < prevEnd) {
                // overlapping interval must be removed
                removals++;
            }
            else {
                // no overlap, keep this interval and update prevEnd
                prevEnd = end;
            }
        }
        return removals;
    }
}
