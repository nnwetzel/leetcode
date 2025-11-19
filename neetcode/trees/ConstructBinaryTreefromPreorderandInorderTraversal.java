import java.util.Arrays;

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
    // - Preorder: root appears first.
    // - Inorder: values left of root are left subtree, values right of root are right subtree.
    // Time: worst-case O(n^2). Space: O(n).

    // PSEUDOCODE:
    // 1. If preorder is empty, return null.
    // 2. Let rootVal be the first preorder element.
    //   - Find rootVal in inorder to get left subtree size.
    //   - Recurse on the left preorder/inorder slices and the right preorder/inorder slices.
    // 3. Return root.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int mid = 0;
        while (inorder[mid] != rootVal) mid++;

        // Left subtree: next 'mid' preorder elements and first 'mid' inorder elements.
        root.left = buildTree(
            // Example: preorder [3,9,20,15,7] -> copyOfRange(preorder, 1, 2) yields [9]
            Arrays.copyOfRange(preorder, 1, 1 + mid),
            // Example: inorder  [9,3,15,20,7] -> copyOfRange(inorder, 0, 1) yields [9]
            Arrays.copyOfRange(inorder, 0, mid)
        );

        // Right subtree: remaining preorder elements and inorder elements after root.
        root.right = buildTree(
            // Example: preorder [3,9,20,15,7] -> copyOfRange(preorder, 2, 5) yields [20,15,7]
            Arrays.copyOfRange(preorder, 1 + mid, preorder.length),
            // Example: inorder  [9,3,15,20,7] -> copyOfRange(inorder, 2, 5) yields [15,20,7]
            Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }
}