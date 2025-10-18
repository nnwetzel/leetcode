class Solution {
    public boolean isValid(String s) {
        // THOUGHT PROCESS:
        // Stack approach for matching parentheses validation - O(n) time, O(n) space
        // Intuition: Use stack to remember opening brackets and match with closing ones
        // Pseudocode:
        // 1. Create map of closing brackets to their opening counterparts
        // 2. Use stack to track opening brackets
        // 3. For each character: if closing bracket, check if it matches top of stack
        // 4. If opening bracket, push to stack
        // 5. Return true if stack is empty at the end
        
        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');

        // Stack remembers opening brackets waiting to be closed
        Stack<Character> stack = new Stack<>();

        // Process each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If current character is a closing bracket
            if (maps.containsKey(c)) {
                // Check if no opening brackets available or wrong type
                if (stack.empty() || stack.pop() != maps.get(c)) {
                    return false;
                }
            }
            else {
                // Opening bracket - save it for later matching
                stack.push(c);
            }
        }
        
        // All brackets matched if stack is empty
        return stack.empty();
    }
}