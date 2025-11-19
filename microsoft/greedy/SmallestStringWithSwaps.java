class Solution {

    // THOUGHT PROCESS:
    // Indices that can be swapped form connected components. For each component,
    // collect its indices and the characters at those indices, sort both, and
    // place the smallest characters at the smallest indices to minimize the string.
    // Time: O(n log n) due to sorting. Space: O(n).

    // PSEUDOCODE:
    // 1. Build adjacency lists from the swap pairs
    // 2. For each index that is not visited:
    //   - find all indices in the same connected component using DFS
    //   - collect the characters at those indices
    //   - sort the list of indices and the list of characters
    //   - assign characters to indices in order so smallest chars go to smallest indices
    // 3. Return the rebuilt string

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        // create adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> p : pairs) {
            adj.get(p.get(0)).add(p.get(1));
            adj.get(p.get(1)).add(p.get(0));
        }

        // array to build the result
        char res[] = s.toCharArray();
        boolean[] visited = new boolean[n];

        // explore each component
        for (int i = 0; i < n; i++) {
            // if index not visited, it's a new component
            if (!visited[i]) {
                // collect all indices in this component
                List<Integer> indices = new ArrayList<>();
                // perform DFS to find all connected indices
                dfs(i, adj, visited, indices);

                // collect characters at these indices
                List<Character> chars = new ArrayList<>();
                for (int idx : indices) {
                    chars.add(res[idx]);
                }
                // sort indices and characters to assign smallest chars to smallest indices
                Collections.sort(indices);
                Collections.sort(chars);

                // place sorted characters at sorted indices
                for (int k = 0; k < indices.size(); k++) {
                    res[indices.get(k)] = chars.get(k);
                }
            }
        }
        return new String(res);
    }

    // PSEUDOCODE:
    // 1. Mark the node visited and add it to the component list
    // 2. For each neighbor of the node:
    //   - if neighbor not visited, recurse into dfs for that neighbor

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> indices) {
        visited[node] = true;
        indices.add(node);
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited, indices);
            }
        }
    }
}