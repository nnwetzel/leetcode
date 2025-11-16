// THOUGHT PROCESS:
// Put words in a prefix trie to test prefixes quickly.
// From each board cell, do DFS following trie edges and mark visited cells.
// Record a word when the trie node signals a complete word.
// Following trie edges prunes many impossible board paths early.
// Time: worst-case O(ROWS * COLS * 4^L). Space: O(total trie size + recursion depth).

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

    // Insert a word into the trie (create nodes as needed)
    public void addWord(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        // mark the node that ends a word
        curr.isWord = true;
    }
}

class Solution {

    private Set<String> foundWords;
    private boolean[][] visited;
    private int ROWS, COLS;

    // PSEUDOCODE:
    // 1. Build a trie from the list of words.
    // 2. For each board cell, start DFS with the root trie node and empty current word.
    // 3. Collect unique matched words and return them as a list.
    public List<String> findWords(char[][] board, String[] words) {
        // build trie of words
        TrieNode root = new TrieNode();
        for (String w : words) root.addWord(w);

        // board dimensions
        ROWS = board.length;
        COLS = board[0].length;

        // container for results and visited tracking
        foundWords = new HashSet<>();
        visited = new boolean[ROWS][COLS];

        // start DFS from every cell
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        // return results as a list
        return new ArrayList<>(foundWords);
    }

    // PSEUDOCODE:
    // 1. If out of bounds, cell visited, or current char not in trie children -> stop.
    // 2. Mark cell visited and append char to current word.
    // 3. If trie child marks a word, add it to results.
    // 4. Recurse to the four neighbors.
    // 5. Unmark visited (backtrack).
    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        // stop if out of bounds
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;
        // stop if this cell is already used in the current path
        if (visited[r][c]) return;

        char ch = board[r][c];

        // follow trie edge for current char; if missing, no words down this path
        TrieNode nextNode = node.children.get(ch);
        if (nextNode == null) return;
        
        // mark this cell as visited for the current path
        visited[r][c] = true;
        // build the new current word
        String newWord = word + ch;

        // if this trie node completes a word, record it
        if (nextNode.isWord) foundWords.add(newWord);

        // explore neighbors (down, right, up, left)
        dfs(board, r + 1, c, nextNode, newWord);
        dfs(board, r, c + 1, nextNode, newWord);
        dfs(board, r - 1, c, nextNode, newWord);
        dfs(board, r, c - 1, nextNode, newWord);

        // unmark visited when backtracking so other paths can use this cell
        visited[r][c] = false;
    }
}
