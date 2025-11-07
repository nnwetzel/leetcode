import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // THOUGHT PROCESS:
        // Brute force: Check every pair of meetings for overlap - O(n²) time
        // Example: For [[0,30],[5,10],[15,20]], compare each pair to find max concurrent meetings
        // This is inefficient because we do many pairwise comparisons
        //
        // Better: Separate start/end times approach - O(n log n) time
        // Pseudocode:
        // 1. Extract start times and end times into separate arrays
        // 2. Sort both arrays independently
        // 3. Use two pointers to track meetings starting vs ending
        //    - When meeting starts before any ends: need new room
        //    - When meeting ends before next starts: can reuse room

        // Example: [[0,30],[5,10],[15,20]] → starts:[0,5,15], ends:[10,20,30]
        // Time 0: starts before end 10 → need room
        // Time 5: starts before end 10 → need room  
        // Time 15: starts after end 10 → reuse room
        
        if (intervals.length == 0) return 0;

        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];

        // Extract start and end times
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Sort both arrays independently
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endPointer = 0;

        // Process each meeting start time
        for (int i = 0; i < n; i++) {
            // If meeting starts before earliest meeting ends, need new room
            if (start[i] < end[endPointer]) {
                rooms++;
            }
            else {
                // A meeting ended, can reuse that room
                endPointer++;
            }
        }
        
        return rooms;
    }
}