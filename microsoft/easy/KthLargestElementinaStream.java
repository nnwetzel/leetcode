class KthLargest {

    // THOUGHT PROCESS:
    // Keep the k largest values seen so far in a min heap.
    // The heap root is the kth largest element.
    // Time: Constructor O(n log k), add O(log k). Space: O(k)
    //
    // PSEUDOCODE:
    // 1. Create an empty min heap
    // 2. Insert each initial number using the add procedure
    // 3. To add a value:
    //    - Push value onto heap
    //    - If heap size exceeds k, pop smallest element
    //    - Return heap root as kth largest
    
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        // insert initial numbers (add function maintains correct heap size)
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // add new value to the min heap
        heap.offer(val);
        // if heap size exceeds k, remove smallest element
        if (heap.size() > k) {
            heap.poll();
        }

        // the root of the min heap is the kth largest element
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */