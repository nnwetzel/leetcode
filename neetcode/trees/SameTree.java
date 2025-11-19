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
        // Traverse both trees using DFS recursion and compare corresponding nodes.
        // If both trees are empty they match.
        // If only one tree is empty they do not match.
        // If the current node values differ they do not match.
        // Otherwise the trees match when the left subtrees match and the right subtrees match.
        // Time O(n) Space O(h)
        //
        // PSEUDOCODE:
        // 1. If both nodes are null return true
        // 2. If only one node is null return false
        // 3. If node values differ return false
        // 4. Recursively check left subtrees and right subtrees and return true only if both match

        // If both are null they match at this position
        if (p == null && q == null) return true;

        // If one is null they do not match
        if (p == null || q == null) return false;

        // If values differ they do not match
        if (p.val != q.val) return false;

        // Recurse on left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}