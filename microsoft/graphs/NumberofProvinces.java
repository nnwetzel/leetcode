class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                provinces++;
                dfs(node, isConnected, visited);
            }
        }
        return provinces;
    }
    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int nei = 0; nei < isConnected.length; nei++) {
            if (isConnected[node][nei] == 1 && !visited[nei]) {
                dfs(nei, isConnected, visited);
            }
        }
    }
}