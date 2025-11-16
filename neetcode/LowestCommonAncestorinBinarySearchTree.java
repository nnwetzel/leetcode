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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // THOUGHT PROCESS:
        // Brute force: find the path to each target and compare paths to find the split — O(n).
        // Optimized: use binary search tree ordering to walk down from the root.
        // If both targets are greater than the current node, the ancestor lies in the right subtree.
        // If both targets are less than the current node, the ancestor lies in the left subtree.
        // Otherwise the current node is where the targets split and is the lowest common ancestor.
        // Time O(h) Space O(1)
        //
        // PSEUDOCODE:
        // 1. Start at the root node
        // 2. While current node exists:
        //   - If both target values are greater than current value go to the right child
        //   - Else if both target values are less than current value go to the left child
        //   - Else return the current node as the lowest common ancestor
        // 3. Return null as a defensive fallback (not expected for valid input)

        TreeNode curr = root;

        // Walk down the tree until the split point is found
        while (curr != null) {
            // If both targets are greater than current, move to the right child
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // If both targets are less than current, move to the left child
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // Otherwise current is the split point and is the lowest common ancestor
            else {
                return curr;
            }
        }

        // Defensive: return null if no ancestor found (should not happen with valid input)
        return null;
    }
}