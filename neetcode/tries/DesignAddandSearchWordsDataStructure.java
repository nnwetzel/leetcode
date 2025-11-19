// THOUGHT PROCESS:
// Store words in a trie so common prefixes are shared. Support '.' as a wildcard by
// recursing through all child nodes when a dot appears. This keeps add fast and lets
// search handle exact matches or wildcard positions.
// Time: addWord O(L). search O(26^k * L) in worst case with k wildcards (L = word length).
// Space: O(total characters stored) for the trie nodes.
class WordDictionary {

    // Trie node: children map and terminal flag
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;
    }

    // root of the trie
    TrieNode root;

    // initialize empty trie
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // PSEUDOCODE:
    // 1. For each character in the word:
    //    - If child for character doesn't exist, create it.
    //    - Move to that child.
    // 2. After the loop mark the node as the end of a word.
    public void addWord(String word) {
        TrieNode curr = root;
        // walk/create nodes for each character
        for (char c : word.toCharArray()) {
            // create child node if missing
            curr.children.putIfAbsent(c, new TrieNode());
            // move to the child node
            curr = curr.children.get(c);
        }
        // mark terminal node
        curr.end = true;
    }
    
    // PSEUDOCODE:
    // 1. Start DFS from root and position 0.
    // 2. If position equals word length, return whether current node is terminal.
    // 3. If char is '.', try all children: if any path returns true, return true.
    // 4. Otherwise follow the child for the character; if missing return false.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS helper that supports '.' wildcard.
    private boolean dfs(String word, int i, TrieNode node) {
        // base case: consumed all characters
        if (i == word.length()) return node.end;

        char c = word.charAt(i);
        // wildcard: try every child
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                // if any child path matches the remainder of the word, return true
                if (dfs(word, i + 1, child)) return true;
            }
            return false;
        }
        // regular character: follow the corresponding child
        else {
            TrieNode next = node.children.get(c);
            if (next == null) return false;
            // continue matching the rest of the word from this child node
            return dfs(word, i + 1, next);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */