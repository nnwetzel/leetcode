import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        // THOUGHT PROCESS:
        // Use iterative in-order traversal (Left, Node, Right) because it yields values in ascending order.
        // Stop early when the k-th smallest is reached.
        // Time O(h + k). Space O(h).

        // PSEUDOCODE:
        // 1. Initialize the stack and set the current node to the root.
        // 2. While the stack is not empty or the current node is not null:
        //   - Push left children until there is no left child.
        //   - Pop the top node and count it as one visited node.
        //   - If the number of visited nodes equals k, return the popped node's value.
        //   - Set the current node to the popped node's right child.
        // 3. Return -1 as a fallback.

        // stack for the iterative DFS (in-order traversal)
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // iterate until there are no nodes left to process
        while (!stack.empty() || curr != null) {
            // go as far left as possible, pushing nodes to revisit later
            while (curr != null) {
                stack.push(curr); // push current node before exploring left
                curr = curr.left; // move left
            }

            // pop the next node in in-order (next smallest)
            curr = stack.pop(); // visit node

            k--; // one more node visited
            if (k == 0) return curr.val; // if this is the k-th visited node, return its value

            // move to the right subtree to continue in-order traversal
            curr = curr.right;
        }

        return -1; // fallback (k assumed valid by problem constraints)
    }
}