class MovingAverage {

    // THOUGHT PROCESS:
    // Maintain a fixed-size queue of the most recent values and a running sum.
    // When a new value arrives, add it and drop the oldest if the window is full,
    // then return sum divided by the number of elements in the window.
    // Time: O(1) per next() call. Space: O(size) for the queue.

    // PSEUDOCODE:
    // 1. Create an empty queue, set window size and sum = 0
    // 2. On next(val):
    //   - add val to queue and sum
    //   - if queue has more than size elements:
    //     - remove oldest and subtract it from sum
    //   - return sum divided by queue size

    private final Queue<Integer> q;
    private final int size;
    private double sum = 0;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        // add new value and include it in the running sum
        q.add(val);
        sum += val;

        // if window exceeded, remove oldest value from sum and queue
        if (q.size() > size) {
            sum -= q.poll();
        }

        // return current average of values in the window
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */