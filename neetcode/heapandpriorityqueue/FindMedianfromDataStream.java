class MedianFinder {
    // THOUGHT PROCESS:
    // Keep two heaps: a max-heap for the smaller half and a min-heap for the larger half.
    // Keep the smaller-half heap at least as large as the larger-half heap and never larger by more than one.
    // With this balance the median is either the top of the smaller-half heap or the average of the two tops.
    // Time: adding a number is logarithmic. Finding the median is constant time. Space: linear.

    // max-heap for the smaller half
    private PriorityQueue<Integer> lower;
    // min-heap for the larger half
    private PriorityQueue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // PSEUDOCODE:
        // 1. Add the number to the lower heap if it belongs to the smaller half, otherwise add it to the upper heap.
        // 2. Rebalance the heaps so their size differ by at most one.
        //    - Move the top element from the larger heap to the smaller heap if their sizes differ by more than one.
        //    - Ensure all elements in the lower heap remain less than or equal to those in the upper heap

        // place number into the appropriate heap
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        }
        else {
            upper.offer(num);
        }

        // rebalance heaps if sizes violate the invariant
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        }
        else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
    // PSEUDOCODE:
    // 1. If both heaps have the same size, return the average of their top values.
    // 2. Otherwise return the top value from the smaller-half heap.

        if (lower.size() == upper.size()) {
            // avoid overflow when summing
            return ((long) lower.peek() + (long) upper.peek()) / 2.0;
        }
        // smaller-half heap holds the extra element when sizes differ
        return lower.peek();
    }
}