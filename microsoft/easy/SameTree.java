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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // THOUGHT PROCESS:
        // Compare trees node by node using recursion - O(n) time, O(h) space
        // Pseudocode:
        // 1. If both nodes are null return true
        // 2. If one node is null or values differ return false
        // 3. Recursively compare left subtrees and right subtrees

        // Both null means identical at this branch
        if (p == null && q == null) return true;

        // If one is null they differ
        if (p == null || q == null) return false;

        // If node values differ they are not the same
        if (p.val != q.val) return false;

        // Both left and right subtrees must match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}