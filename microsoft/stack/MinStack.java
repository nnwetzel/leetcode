class MinStack {
    // THOUGHT PROCESS:
    // Use a stack to store pairs of value and current minimum so all operations are O(1)
    // Time complexity: O(1) for push pop top getMin. Space complexity: O(n)
    //
    // Pseudocode:
    // 1. On push value
    //   - If stack empty push pair of value and value as current min
    //   - Otherwise push pair of value and min(value, current min)
    // 2. On pop remove top pair
    // 3. On top return top value
    // 4. On getMin return top current min

    // Stack stores pairs of [value, current minimum at or below this node]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {}

    // Push value and current minimum at this position
    public void push(int val) {
        // If stack is empty then val is the current minimum for the stack
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
            return;
        }
        // Get current min and push new pair with updated min
        int currentMin = stack.peek()[1];
        stack.push(new int[] {val, Math.min(val, currentMin)});
    }

    // Remove the top pair
    public void pop() {
        stack.pop();
    }

    // Return the value at the top of the stack
    public int top() {
        return stack.peek()[0];
    }

    // Return the current minimum for the stack
    public int getMin() {
        return stack.peek()[1];
    }
}