class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // THOUGHT PROCESS:
        // Sort by start time then check for overlaps
        // Time: O(n log n) due to sorting. Space: O(1).

        // PSEUDOCODE:
        // 1. Sort intervals by start time
        // 2. Check each adjacent pair for overlap
        // 3. If any overlap found: return false
        // 4. If no overlaps: return true
        
        // sort intervals by start time for easy overlap detection
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // check adjacent intervals for overlap
        for (int i = 1; i < intervals.length; i++) {
            // if previous meeting ends after current meeting starts: overlap
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        
        return true;
    }
}