class Solution {
    public boolean isValid(String s) {
        // THOUGHT PROCESS:
        // Use a stack to match closing brackets with their opening counterparts
        // Time O(n) Space O(n)
        //
        // PSEUDOCODE:
        // 1. Build a map of closing -> opening brackets
        // 2. For each character in the string
        //   - If character is a closing bracket
        //     - If stack is empty or top does not match return false
        //   - Otherwise push the character onto the stack
        // 3. Return true if stack is empty

        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');

        // Stack holds opening brackets waiting to be matched
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If current character is a closing bracket
            if (maps.containsKey(c)) {
                // If no opening bracket to match or wrong type then invalid
                if (stack.empty() || stack.pop() != maps.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket - push for later matching
                stack.push(c);
            }
        }

        // Valid if no unmatched opening brackets remain
        return stack.empty();
    }
}