/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) { val = _val; }
    public Node(int _val, List<Node> _children) { val = _val; children = _children; }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }

        int max = 0;
        // DFS recursion: explore all children of the current node
        for (Node child : root.children) {
            int childDepth = maxDepth(child); // recursive depth of each subtree
            max = Math.max(max, childDepth);  // track maximum depth seen so far
        }

        // Add 1 for the current root node
        return max + 1;
    }
}