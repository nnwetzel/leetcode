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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // THOUGHT PROCESS:
        // Check every node in the main tree as a potential root of subRoot.
        // For each node, compare the two trees directly.
        // This uses DFS traversal for both steps.
        // Time O(m * n) Space O(h)  (m = nodes in root, n = nodes in subRoot, h = recursion height)
        //
        // PSEUDOCODE:
        // 1. If subRoot is empty return true
        // 2. If root is empty return false
        // 3. If trees match at current root return true
        // 4. Otherwise check left subtree and right subtree of root

        if (subRoot == null) return true;   // empty tree is always a subtree
        if (root == null) return false;     // main tree exhausted without match

        // If trees match at this node return true
        if (sameTree(root, subRoot)) return true;

        // Otherwise try matching in left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Compare two trees for exact equality
    private boolean sameTree(TreeNode a, TreeNode b) {
        // If both nodes are null they match here
        if (a == null && b == null) return true;

        // If only one is null or values differ they don't match
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        // Recurse on left and right children
        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }
}