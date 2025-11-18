class Solution {
    public boolean backspaceCompare(String s, String t) {
        // THOUGHT PROCESS:
        // Brute force: Build final string for each input using a stack - O(n) time, O(n) space
        // This simulates typing with backspaces and compares the results
        //
        // Pseudocode:
        // 1. For each string, process characters one by one
        // 2. If character is not '#', push to stack
        // 3. If character is '#', pop from stack if not empty
        // 4. After processing, convert stack to string
        // 5. Compare the two processed strings for equality
        
        return build(s).equals(build(t));
    }

    public String build(String s) {
        Stack<Character> ans = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                ans.push(c); // Add character to stack
            } else if (!ans.empty()) {
                ans.pop();   // Remove last character for backspace
            }
        }
        return String.valueOf(ans); // Convert stack to string
    }
}