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
    public int maxDepth(TreeNode root) {
        // THOUGHT PROCESS:
        // Use recursion to compute tree height — visit each node once
        // Pseudocode:
        // 1. If node is null return zero
        // 2. Return one plus the maximum of left and right subtree depths

        // Base case: empty tree has depth 0
        if (root == null) return 0;

        // Recurse left and compute its depth
        int left = maxDepth(root.left);

        // Recurse right and compute its depth
        int right = maxDepth(root.right);

        // Return current node contribution plus the larger of the two subtree depths
        return 1 + Math.max(left, right);
    }
}