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
    public Node connect(Node root) {
        // THOUGHT PROCESS:
        // Brute force: Use BFS with queue to track each level - O(n) time, O(n) space
        // This works but uses extra space for the queue
        //
        // Better: Use existing next pointers from previous level - O(n) time, O(1) space
        // Pseudocode:
        // 1. Start from root, process level by level
        // 2. For each level, use current level's next pointers to traverse
        // 3. Connect children of current level nodes
        // 4. Move to next level using left child
        
        if (root == null) {
            return root;
        }

        Node leftNode = root;  // Leftmost node of current level

        // Process each level while it has children
        while (leftNode.left != null) {
            Node head = leftNode;  // Start of current level
            
            // Connect all children in the next level
            while (head != null) {
                // Connect left child to right child
                head.left.next = head.right;
                
                // Connect right child to next node's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;  // Move to next node in current level
            }
            
            leftNode = leftNode.left;  // Move to next level
        }
        
        return root;
    }
}

/* BFS SOLUTION (for reference):
public Node connect(Node root) {
    if (root == null) return root;
    
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            if (i < size - 1) node.next = queue.peek();
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
    
    return root;
}
*/