import java.util.Map;
import java.util.HashMap;

class Solution {

    // THOUGHT PROCESS:
    // Sum Roman values from start to finish, but subtract a value from the sum
    // when the next roman numeral is larger
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Build a map from Roman characters to integers
    // 2. Set total to 0
    // 3. For each character from left to right:
    //   - If this value is less than the next value, subtract it from total
    //   - Otherwise add it to total
    // 4. Return total

    public int romanToInt(String s) {
        // map single Roman characters to their integer values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();
        // scan characters left to right and add/subtract using lookahead
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            // if current value is less than next value, subtract it
            if (i + 1 < n && value < map.get(s.charAt(i + 1))) {
                total -= value;
            }
            else {
                total += value;
            }
        }
        return total;
    }
}