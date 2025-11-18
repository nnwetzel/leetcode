class Solution {

    static Map<String, Integer> values = new HashMap<>();

    static {
        // Map Roman numeral symbols to integer values
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);   // Subtractive notation cases
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {
        // Greedy approach with variable step sizes - O(n) time, O(1) space
        // Intuition: Process longest valid symbols first to handle subtractive notation
        // Example: "MCMXC" = M(1000) + CM(900) + XC(90) = 1990
        
        int sum = 0;
        int i = 0;
        
        // Use while loop for variable step sizes - O(n) iterations
        while (i < s.length()) {
            // Try two-character symbol first (subtractive cases)
            if (i < s.length() - 1) {
                String twoChar = s.substring(i, i + 2);
                
                if (values.containsKey(twoChar)) {
                    sum += values.get(twoChar);
                    i += 2;  // Skip both characters
                    continue;
                }
            }
            
            // Process single character
            String singleChar = s.substring(i, i + 1);
            sum += values.get(singleChar);
            i++;
        }
        
        return sum;
    }
}