class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // THOUGHT PROCESS:
        // Min-heap of size k - O(n log k) time, O(n) space
        // Pseudocode:
        // 1. Count frequency of each number using HashMap
        // 2. Use min-heap to keep only k most frequent elements
        // 3. If heap exceeds size k, remove least frequent element
        // 4. Extract elements from heap to build result array
        
        // Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Min-heap: keeps least frequent element at top
        // Comparator: (n1, n2) -> freq.get(n1) - freq.get(n2) means sort by frequency
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> freq.get(n1) - freq.get(n2));
        
        // Keep only k most frequent elements in heap
        for (int n : freq.keySet()) {
            heap.add(n);
            // If heap exceeds k elements, remove least frequent (top of min-heap)
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        // Build result array from heap (extract in reverse order)
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll(); // Most frequent elements come out last
        }
        return top;
    }
}