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
    public TreeNode invertTree(TreeNode root) {
        // THOUGHT PROCESS:
        // Swap left and right children for every node (recursively).
        // Time O(n) — visit each node once. Space O(h) for recursion stack (h = tree height).
        //
        // PSEUDOCODE:
        // 1. If node is null return null
        // 2. Swap node's left and right
        // 3. Recursively invert left and right subtrees
        // 4. Return node

        if (root == null) return null;

        // Swap children
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        // Invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}