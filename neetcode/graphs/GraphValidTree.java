class Solution {
    // THOUGHT PROCESS:
    // Check two things: the graph must have exactly n - 1 edges, and it must be fully connected with no cycles.
    // So first verify edge count, then run DFS from node 0 to detect cycles and mark reachable nodes.
    // If DFS finds a cycle or not all nodes are reached, it's not a valid tree.
    // Time: O(n + edges). Space: O(n).

    // PSEUDOCODE:
    // 1. If the number of edges is not n - 1, it's not a tree -> return false.
    // 2. Build an adjacency list for the undirected graph.
    // 3. Run DFS from node 0 to detect cycles and mark reachable nodes.
    // 4. If DFS found a cycle return false; otherwise return true only if all nodes were visited.
    public boolean validTree(int n, int[][] edges) {
        // base case: a tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // dfs returns false when we have a cycle
        if (!dfs(0, -1, visited, adj)) return false;

        // ensure graph is connected (all nodes visited)
        return visited.size() == n;
    }

    // PSEUDOCODE:
    // 1. If this node was already visited, we've found a cycle -> return false.
    // 2. Mark the node visited.
    // 3. For each neighbor:
    //    - If neighbor is the parent, skip it (ignore the edge we came from).
    //    - Recurse to neighbor; if recursion reports a cycle return false.
    // 4. If no cycles found return true.
    public boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adj) {
        
        // visited before on this traversal -> cycle detected
        if (visited.contains(node)) return false;

        // mark current node as visited
        visited.add(node);

        for (int nei : adj.get(node)) {
            // ignore the edge back to parent to avoid false positive cycle
            if (nei == parent) continue;
            // if any neighbor exploration finds a cycle, propagate false
            if (!dfs(nei, node, visited, adj)) return false;
        }
        return true;
    }
}
