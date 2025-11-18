/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // THOUGHT PROCESS:
    // For a perfect binary tree, connect next pointers level by level without extra data structures.
    // Use the already-established next pointers on the current level to link children on the next level.
    // Time: O(n). Space: O(1) extra.

    // PSEUDOCODE:
    // 1. If there is no root return the root.
    // 2. Start at the leftmost node of the current level.
    // 3. While the next level exists:
    // - Walk across the current level using next pointers and connect each node's children.
    // - Move down to the leftmost node of the next level.
    // 4. Return root.
    public Node connect(Node root) {
        if (root == null) return root;

        // leftmost node of the current level
        Node leftmost = root;

        // stop when we've reached the leaf level
        while (leftmost.left != null) {
            Node node = leftmost;

            // traverse current level using next pointers and set next pointers for children
            while (node != null) {
                // connect left child to right child
                node.left.next = node.right;

                // connect right child to next node's left child if next exists
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                // move to next node in current level
                node = node.next; 
            }

            // move down one level
            leftmost = leftmost.left;
        }
        return root;
    }
}

/* BFS alternative (uses extra space - for reference):
public Node connect(Node root) {
    if (root == null) return root;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    if (root == null) return root;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);= null;
    while (!q.isEmpty()) {< sz; i++) {
        int sz = q.size();oll();
        Node prev = null;ull) prev.next = cur;
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();) q.offer(cur.left);
            if (prev != null) prev.next = cur;.right);
            prev = cur;
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
    }    return root;}*/