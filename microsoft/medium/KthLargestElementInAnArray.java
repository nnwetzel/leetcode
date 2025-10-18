class Solution {
    public int findKthLargest(int[] nums, int k) {
        // THOUGHT PROCESS:
        // Brute force: Sort array and return element at index n-k - O(n log n) time
        // This works but sorting the entire array is overkill
        //
        // Better: Min-heap of size k - O(n log k) time, O(k) space
        // Pseudocode:
        // 1. Maintain a min-heap of size k
        // 2. For each number, add to heap
        // 3. If heap size exceeds k, remove smallest element
        // 4. Root of heap is the kth largest element
        
        // Min-heap approach - keep only k largest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            // Add current number to heap
            heap.add(num);
            
            // If heap exceeds size k, remove smallest element
            if (heap.size() > k) {
                heap.remove();
            }
        }

        // Root contains kth largest element
        return heap.peek();
    }
}

/* BRUTE FORCE SOLUTION:
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}
*/