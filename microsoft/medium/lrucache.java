class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    // THOUGHT PROCESS:
    // HashMap + Doubly Linked List - O(1) time for all operations
    // Pseudocode:
    // 1. HashMap for O(1) key-to-node lookup
    // 2. Doubly linked list for O(1) insertion/deletion
    // 3. Most recent at tail, least recent at head
    // 4. When capacity exceeded: remove head.next (least recent)
    
    int capacity;
    Map<Integer, ListNode> dic;  // HashMap for O(1) key lookup
    ListNode head;  // Dummy head (least recent side)
    ListNode tail;  // Dummy tail (most recent side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        // Create dummy head and tail for easier edge case handling
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        // Move accessed node to most recent position (tail)
        ListNode node = dic.get(key);
        remove(node);  // Remove from current position
        add(node);     // Add to tail (most recent)
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            // Update existing key: remove old node
            ListNode oldNode = dic.get(key);
            remove(oldNode);
        }

        // Create new node with the key-value pair to be cached
        ListNode node = new ListNode(key, value);
        dic.put(key, node);  // Store in HashMap for O(1) lookup
        add(node);           // Add to tail as most recently used

        // Check capacity: remove least recent if exceeded
        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;  // Least recent node
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    // Add node to tail (most recent position)
    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    // Remove node from its current position
    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */