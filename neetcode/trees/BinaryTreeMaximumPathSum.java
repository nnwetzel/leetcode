class Solution {
    // THOUGHT PROCESS:
    // We use DFS to explore every node and calculate the best path sum starting from each one.
    // For each node, we check:
    // - The best path sum from the left and right sides.
    // - Whether connecting both sides through this node gives a higher total.
    // A path can only connect two branches once; another connection would break the single path rule.
    // Time: O(n), Space: O(h)
    //
    // PSEUDOCODE:
    // 1. If the node is null, return 0
    // 2. Recursively find the best sums from the left and right sides
    //    - If a side sum is negative, use 0 instead
    // 3. Calculate total = node value + left + right (path through this node)
    //    - Update the global max if total is larger
    // 4. Return node value + max(left, right)
    //    - Only one side can continue upward in a single path

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // best downward gains from children, ignoring negatives
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        // possible split path through this node
        int split = node.val + left + right;
        maxSum = Math.max(maxSum, split);

        // return best single downward branch
        return node.val + Math.max(left, right);
    }
}