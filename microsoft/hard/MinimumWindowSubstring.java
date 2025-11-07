class Solution {
    public String minWindow(String s, String t) {
        // THOUGHT PROCESS:
        // Find the smallest window in s that contains all characters of t
        // Use a frequency map for t and a sliding window over s that expands right and contracts left
        // When window covers all required chars record length then try to shorten from left
        // Time complexity O(n + m) Space complexity O(k) where k is number of distinct chars in t
        //
        // PSEUDOCODE:
        // 1. Count required characters from t into countT
        // 2. Slide right over s adding chars to window
        //   - When window satisfies all required counts try to move left to shorten window
        //   - Update best window when found
        // 3. Return smallest window or empty string if none

        // countT maps each character in t to how many are required
        Map<Character, Integer> countT = new HashMap<>();
        // window maps each character in the current window to its count
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = { -1, -1 };
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            // Add the character at right into the window counts
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            // If this character is required and we've met the required count increment have
            if (countT.containsKey(rightChar) && window.get(rightChar).equals(countT.get(rightChar))) {
                have++;
            }

            // While current window contains all required characters try to shrink from the left
            while (have == need) {
                // If current window is smaller record it
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                // Remove left char from window as we move left forward
                window.put(leftChar, window.get(leftChar) - 1);

                // If leftChar was required and we dropped below required count decrement have
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}