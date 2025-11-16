class PrefixTree {
    // THOUGHT PROCESS:
    // A TrieNode stores a map of children keyed by character and a flag marking the end of a word.
    // This lets the trie share common prefixes so insert/search walk character-by-character.
    // Example tree for words {"app", "apple"}:

    // (root)
    //  └─ a
    //     └─ p
    //        └─ p (end of "app")
    //           └─ l
    //              └─ e (end of "apple")

    // Time: insert/search/startsWith are O(L) where L is the word length.
    // Space: O(total characters stored) for the trie nodes.

    public class TrieNode {
    // children: map from character to next TrieNode (shared prefixes)
    Map<Character, TrieNode> children = new HashMap<>();
    // end: true if this node marks the end of a stored word
    boolean end = false;
}
    private TrieNode root;

    // initialize empty trie with a root node
    public PrefixTree() {
        // root represents empty prefix
        root = new TrieNode();
    }

    // PSEUDOCODE:
    // 1. For each character in the word:
    //    - If a child for the character doesn't exist, create it.
    //    - Move to that child.
    // 2. After the loop, mark the current node as the end of a word.
    public void insert(String word) {
        TrieNode curr = root;
        // walk/create nodes for each character
        for (char c : word.toCharArray()) {
            // create child node if missing
            curr.children.putIfAbsent(c, new TrieNode());
            // move to the child node
            curr = curr.children.get(c);
        }
        // mark the node as terminal for this word
        curr.end = true;
    }

    // PSEUDOCODE:
    // 1. For each character in the word:
    //    - If the child for the character is missing, return false.
    //    - Move to that child.
    // 2. After the loop, return true only if the current node is marked as a word end.
    public boolean search(String word) {
        TrieNode curr = root;
        // traverse nodes for each character
        for (char c : word.toCharArray()) {
            // missing child -> word not present
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        // only true if this node marks the end of a stored word
        return curr.end;
    }

    // PSEUDOCODE:
    // 1. For each character in the prefix:
    //    - If the child for the character is missing, return false.
    //    - Move to that child.
    // 2. If all characters found, return true.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        // traverse nodes for each prefix character
        for (char c : prefix.toCharArray()) {
             // missing char -> no such prefix
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        // all prefix characters found
        return true;
    }
}
