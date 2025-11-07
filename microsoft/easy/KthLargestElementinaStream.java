class KthLargest {

    // THOUGHT PROCESS:
    // Keep the k largest values seen so far in a min heap.
    // The heap root is the kth largest element.
    // Time complexity: Constructor O(n log k), add O(log k). Space complexity: O(k)
    //
    // PSEUDOCODE:
    // 1. Create an empty min heap
    // 2. Insert each initial number using the add procedure
    // 3. To add a value:
    //    - If heap size is less than k push value
    //    - Else if value is larger than heap root replace root with value
    //    - Return heap root as kth largest

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        // Record k and create the min heap that will hold up to k largest elements
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial numbers using the same logic as add so heap size is maintained
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // If heap is not yet holding k elements then add the new value
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }
        // Otherwise only add the new value if it is larger than the smallest in heap
        else if (val > minHeap.peek()) {
            // Insert new value and remove the smallest to keep only k largest values
            minHeap.offer(val);
            minHeap.poll();
        }

        // The root of the min heap is the kth largest element
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */