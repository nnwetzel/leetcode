class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // THOUGHT PROCESS:
        // Brute force: For each day, scan forward to find next warmer day - O(n²) time
        // Better: Stack to track days waiting for warmer temperature - O(n) time
        // Pseudocode:
        // 1. For each day, check if it's warmer than days waiting in stack
        // 2. If yes: pop those days and calculate their wait time
        // 3. Add current day to stack (still waiting)
        
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stores day indices

        for (int today = 0; today < n; today++) {
            // Help all cooler days that were waiting
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[today]) {
                int waitingDay = stack.pop();
                result[waitingDay] = today - waitingDay;
            }
            
            // Today starts waiting for a warmer day
            stack.push(today);
        }
        
        return result;
    }
}

/* BRUTE FORCE SOLUTION:
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (temperatures[j] > temperatures[i]) {
                result[i] = j - i;
                break;
            }
        }
    }
    
    return result;
}
*/