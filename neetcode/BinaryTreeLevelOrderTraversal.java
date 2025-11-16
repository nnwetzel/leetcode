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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // THOUGHT PROCESS:
        // Use breadth first search with a queue to collect nodes level by level.
        // Time O(n) Space O(n)
        //
        // PSEUDOCODE:
        // 1. If the tree is empty return an empty list
        // 2. Put the root in a queue
        // 3. While the queue has nodes:
        //   - Record how many nodes are in the queue (this is the current level size)
        //   - Remove that many nodes, recording their values and adding their children to the queue
        //   - Add the recorded values as one level in the result
        // 4. Return the result list

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // empty tree

        // queue holds nodes to process, level by level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // process until no nodes remain
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            // number of nodes in the current level
            int levelSize = q.size();

            // process every node in this level
            for (int i = 0; i < levelSize; i++) {
                // take the next node from the queue for processing
                TreeNode node = q.poll();
                // record its value for this level
                level.add(node.val);

                // enqueue children for the next level
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // add the current level's values to the result
            res.add(level);
        }
        return res;
    }
}