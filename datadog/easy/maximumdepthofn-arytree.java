/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        int max = 0;
        // Go through each child of the current node
        for (Node child : root.children) {
            // Find the depth of the child's subtree
            int childDepth = maxDepth(child);
            // Keep track of the deepest subtree we've seen so far
            max = Math.max(max, childDepth);
        }

        // Add 1 to count the current node's level
        return max + 1;
    }
}
