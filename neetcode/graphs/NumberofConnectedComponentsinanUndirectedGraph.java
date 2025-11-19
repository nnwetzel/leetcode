class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        // create an adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        // go through all nodes, if we find a node that is not visited yet increment component count by 1
        // use dfs on that node to mark all connected nodes as visited. we can skip checking visited nodes
        // because they are part of the connected component that has already been counted
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                res++;
                dfs(visited, adj, node);
            }
        }
        return res;
    }
    private void dfs(boolean[] visited, List<List<Integer>> adj, int node) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) dfs(visited, adj, nei);
        }
    }
}