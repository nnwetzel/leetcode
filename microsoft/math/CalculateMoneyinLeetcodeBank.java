class Solution {
    // THOUGHT:
    // Each week starts one dollar higher. Within a week each day gives one dollar more than the previous.
    // Simulate week by week until n days are used and sum the daily amounts.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Set total = 0 and start = 1
    // 2. While days remain:
    //   - For up to seven days or until no days left:
    //     - add current day amount to total
    //     - increase current day amount by one
    //     - decrease remaining days by one
    //   - increase start by one
    // 3. Return total

    public int totalMoney(int n) {
        int total = 0;
        int start = 1;

        // simulate each week until we run out of days
        while (n > 0) {
            int curr = start;
            // add up to seven days for this week or until we run out of days (handles partial weeks)
            for (int i = 0; i < 7 && n > 0; i++) {
                // add current day amount to total
                total += curr;
                // increase current day amount by one
                curr++;
                n--;
            }
            // increase start amount for next week
            start++;
        }
        return total;
    }
}