import java.util.ArrayList;
import java.util.List;

class Solution {

    // THOUGHT PROCESS:
    // Insert a new interval into a sorted list and merge any overlaps in one pass.
    // Do three phases: add non-overlapping intervals before, merge overlaps with the new
    // interval, then add the remaining intervals.
    // Time: O(n). Space: O(n) for the output list.

    // PSEUDOCODE:
    // 1. Add intervals that end before the new interval starts.
    // 2. Merge intervals that overlap the new interval by expanding its start/end.
    //   - An interval overlaps if its start is less than or equal to newInterval end.
    // 3. Add the merged new interval.
    // 4. Add the rest of the intervals.

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: add intervals that come completely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Phase 2: merge all intervals that overlap with newInterval
        // at this point, intervals are either overlapping or come after newInterval so
        // any interval whose start is <= newInterval end overlaps and should be merged.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the merged new interval
        res.add(newInterval);

        // Phase 3: add remaining intervals that come after newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        // convert list to array and return
        return res.toArray(new int[res.size()][]);
    }
}
