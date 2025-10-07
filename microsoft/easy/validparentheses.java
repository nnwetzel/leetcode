class Solution {
    public boolean isValid(String s) {
        // Stack approach for matching parentheses validation
        // Intuition: Use stack to remember opening brackets and match with closing ones
        // Example: "()[]{}" → valid, "([)]" → invalid (wrong nesting order)
        
        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> maps = new HashMap<Character, Character>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');

        // Stack remembers opening brackets waiting to be closed
        Stack<Character> stack = new Stack<Character>();

        // Process each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If current character is a closing bracket
            if (maps.containsKey(c)) {
                // Two checks: no opening brackets available OR wrong type of opening bracket
                // Example: ")" fails (empty stack), "([)]" fails (')' needs '(' but finds '[')
                // stack.pop() removes and returns the most recent opening bracket
                if (stack.empty() || stack.pop() != maps.get(c)) {
                    return false;
                }
            }
            else {
                // Opening bracket - save it for later matching
                // stack.push() adds opening bracket to top of stack
                stack.push(c);
            }
        }
        
        // All brackets matched if stack is empty
        // Example: "(((" has leftover opening brackets
        return stack.empty();
    }
}