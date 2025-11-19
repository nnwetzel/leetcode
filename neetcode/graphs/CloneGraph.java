/*
// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() { val = 0; neighbors = new ArrayList<Node>(); }
//     public Node(int _val) { val = _val; neighbors = new ArrayList<Node>(); }
//     public Node(int _val, ArrayList<Node> _neighbors) { val = _val; neighbors = _neighbors; }
// }
*/

class Solution {
    // THOUGHT PROCESS:
    // Copy the graph node-by-node using depth-first search. Keep a map from original nodes
    // to their clones so we reuse clones for already-seen nodes and avoid infinite loops
    // from cycles. Each node clone is created once, then its neighbors are filled by recursing.
    // Time: O(V + E). Space: O(V).

    // PSEUDOCODE:
    // 1. If input node is null, return null.
    // 2. Create an empty map from original -> clone.
    // 3. Start DFS from the input node to build and return its clone.
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // map original node -> cloned node
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    // PSEUDOCODE:
    // 1. If node already cloned (in map) return the clone.
    // 2. Create clone for current node and put it in the map.
    // 3. For each neighbor, recurse to get its clone and add to current clone's neighbors.
    // 4. Return the clone.
    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        // if node was already copied, return stored clone
        if (oldToNew.containsKey(node)) return oldToNew.get(node);

        // create clone for current node and record it before recursing neighbors
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        // fill neighbors by recursing (handles cycles by using the map)
        for (Node nei : node.neighbors) copy.neighbors.add(dfs(nei, oldToNew));

        return copy;
    }
}