class Solution {

    static Map<String, Integer> values = new HashMap<>();

    static {
        // Map of all Roman numeral symbols to their integer values
        // Single characters and special two-character combinations
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);   // Special case: 4 (not IIII)
        values.put("IX", 9);   // Special case: 9 (not VIIII)
        values.put("XL", 40);  // Special case: 40 (not XXXX)
        values.put("XC", 90);  // Special case: 90 (not LXXXX)
        values.put("CD", 400); // Special case: 400 (not CCCC)
        values.put("CM", 900); // Special case: 900 (not DCCCC)
    }

    public int romanToInt(String s) {
        // Greedy approach: process longest valid symbols first
        // Intuition: Roman numerals use subtractive notation for specific cases
        // Example: "MCMXC" = M(1000) + CM(900) + XC(90) = 1990
        
        int sum = 0;
        int i = 0;
        
        // Use while loop because we need variable step sizes (1 or 2 characters)
        // Can't use for loop since we might skip ahead when finding two-char symbols
        while (i < s.length()) {
            // First, try to match a two-character symbol (subtractive cases)
            if (i < s.length() - 1) {
                String twoChar = s.substring(i, i + 2);
                
                // If we find a special two-character combination, use it
                if (values.containsKey(twoChar)) {
                    sum += values.get(twoChar);
                    i += 2;  // Skip both characters
                    continue;
                }
            }
            
            // Otherwise, process single character
            String singleChar = s.substring(i, i + 1);
            sum += values.get(singleChar);
            i++;
        }
        
        return sum;
    }
}