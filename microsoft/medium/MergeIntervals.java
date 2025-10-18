class Solution {
    public int[][] merge(int[][] intervals) {
        // THOUGHT PROCESS:
        // Brute force: Compare every interval with every other - O(n²), too slow
        // Optimal: Sort by start, then merge in one pass - O(n log n)
        // Pseudocode:
        // 1. Sort intervals by start time
        // 2. For each interval:
        //    - If no overlap, add as new interval
        //    - If overlap, merge by extending end time

        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use LinkedList for efficient access and update of the last merged interval
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // If merged is empty, add the first interval.
            // If the end of the last merged interval is less than the start of the current interval,
            // there is no overlap, so add the current interval as a new one.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // Otherwise, there is overlap:
            // Extend the end of the last merged interval if the current interval goes further.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}