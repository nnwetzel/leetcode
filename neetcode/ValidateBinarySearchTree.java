/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // THOUGHT PROCESS:
        // Use recursion with value bounds to validate the BST property for every node.
        // Each node must lie strictly between the lower and upper bounds passed from ancestors.
        // Time O(n) Space O(h)
        //
        // Example (invalid BST):
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        // Bounds checks:
        //   -inf < 5 < +inf
        //   -inf < 1 < 5
        //   5 < 4 < +inf   <-- violated here

        // Return true only if every node satisfies lower < node.val < upper
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long lower, long upper) {
        if (node == null) return true;

        // Check that node value is strictly inside (lower, upper)
        if (!(node.val > lower && node.val < upper)) return false;

        // Recurse: left in (lower, node.val) and right in (node.val, upper)
        return valid(node.left, lower, node.val)
            && valid(node.right, node.val, upper);
    }
}