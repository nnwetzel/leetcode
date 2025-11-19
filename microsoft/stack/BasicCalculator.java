class Solution {

    // THOUGHT PROCESS:
    // Evaluate an expression with plus, minus and parentheses by scanning left to right,
    // building numbers, applying the current sign, and using a stack to save the running
    // result and sign when entering parentheses.
    // Time: O(n). Space: O(n).

    PSEUDOCODE:
    // 1. Initialize result = 0, sign = +1, current number = 0, and an empty stack
    // 2. For each character in the string:
    //   - if it's a digit, extend the current number
    //   - if it's '+' or '-', add current number times sign to result, reset number, set sign
    //   - if it's '(', push result and sign to stack, reset result and sign
    //   - if it's ')', add current number times sign to result, pop sign and previous result, combine
    // 3. After the loop add any remaining number times sign to result and return it

    public int calculate(String s) {
        // running total for the current frame
        int res = 0;
        // current sign (+1 or -1)
        int sign = 1;
        // current number being parsed
        int num = 0;

        Stack<Integer> stack = new Stack<>(); // holds previous result and sign when '(' encountered
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // build the current number
                num = num * 10 + (c - '0');
            }
            else if (c == '+') {
                // commit the current number and set sign to plus
                res += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                // commit the current number and set sign to minus
                res += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                // save current state and start a new frame
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (c == ')') {
                // finish current frame, combine with saved state
                res += sign * num;
                num = 0;

                int prevSign = stack.pop(); // sign before the '('
                int prevRes = stack.pop();  // result before the '('

                res = prevRes + prevSign * res;
            }
            // ignore whitespace and any other characters
        }
        // commit any remaining number
        return res + sign * num;
    }
}