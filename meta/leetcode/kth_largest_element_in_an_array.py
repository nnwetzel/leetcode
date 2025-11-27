import heapq
from typing import List

# Time: O(N log k) - we push/pop N elements in a heap of size k
# Space: O(k) - heap of size k
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # use a min-heap to keep track of the k largest elements
        min_heap = []
        
        for num in nums:
            heapq.heappush(min_heap, num)
            # if heap exceeds size k, remove smallest element
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        # the root of the min-heap is the kth largest element
        return min_heap[0]