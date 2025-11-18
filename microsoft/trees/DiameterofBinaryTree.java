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
    // THOUGHT PROCESS:
    // Use one DFS that returns the longest downward path (height) from a node.
    // At each node the longest path through it equals left height plus right height;
    // keep the maximum of those sums as the diameter.
    // Time: O(n). Space: O(tree height).
    
    // PSEUDOCODE:
    // 1. Set diameter to zero.
    // 2. DFS(node) returns longest downward edge count from node.
    // 3. In DFS: get left and right heights, update diameter with left + right + 2, return max(left, right) + 1.
    // 4. Run DFS on root and return diameter.

    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return -1;

        // get longest downward paths from left and right children
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);
        // update diameter if path through this node is larger
        diameter = Math.max(diameter, leftPath + rightPath + 2);
        // return longest downward path from this node
        return Math.max(leftPath, rightPath) + 1;
    }
}