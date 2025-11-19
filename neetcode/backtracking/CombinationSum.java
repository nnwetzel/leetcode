public class Solution {
    // Try numbers in increasing order and build a running combination.
    // Keep adding a number until the running sum reaches or goes past the target.
    // - If it equals the target, save the combination.
    // - If it goes past the target, undo the last choice and try the next number.
    // - Allow reuse by not advancing the start index when recursing.
    // Time: exponential in the worst case. Space: O(depth + output).
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        // PSEUDOCODE:
        // 1. Sort the candidate numbers so larger numbers can be pruned early.
        // 2. Start backtracking from index 0 with an empty list and remain = target.
        res = new ArrayList<>();
        // sort to enable pruning when sum would exceed target
        Arrays.sort(nums);

        // start recursion
        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    // PSEUDOCODE:
    // 1. If running sum equals target:
    //    - Record a copy of the current list and return.
    // 2. Otherwise, for each candidate from start index to end:
    //    - If adding candidate makes the sum exceed target, stop this loop (prune).
    //    - Add the candidate, recurse using the same start index (allow reuse), then remove the candidate (backtrack).
    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        // if we've reached the target, record the combination
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // try each candidate starting from index i
        for (int j = i; j < nums.length; j++) {
            int next = total + nums[j];
            // prune: array is sorted so further candidates will only be larger
            if (next > target) return;

            // choose nums[j]
            cur.add(nums[j]);
            // recurse allowing reuse of nums[j] (hence j, not j+1)
            dfs(j, cur, next, nums, target);
            // backtrack: remove last chosen number
            cur.remove(cur.size() - 1);
        }
    }
}