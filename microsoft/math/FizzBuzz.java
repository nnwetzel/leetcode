class Solution {
    // THOUGHT PROCESS:
    // For each number from 1 to n, output "Fizz" for multiples of 3, "Buzz" for multiples of 5,
    // and "FizzBuzz" when both apply. Otherwise output the number as a string.
    // Time: O(n). Space: O(1) excluding output list.

    // PSEUDOCODE:
    // 1. Make an empty list of strings.
    // 2. For each i from 1 to n:
    //   - If i divisible by both 3 and 5, add "FizzBuzz"
    //   - Else if i divisible by 3, add "Fizz"
    //   - Else if i divisible by 5, add "Buzz"
    //   - Else add i as text
    // 3. Return the list.
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // multiples of both 3 and 5 come first
            if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");   // multiples of 3
            else if (i % 5 == 0) res.add("Buzz");   // multiples of 5
            else res.add(Integer.toString(i));      // neither, use the number
        }
        return res;
    }
}