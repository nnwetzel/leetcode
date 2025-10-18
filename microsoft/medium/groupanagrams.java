class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // THOUGHT PROCESS:
        // Brute force: Compare every string with every other string - O(n² * k) time
        // Example: For ["eat","tea","tan","ate"], check if "eat" anagram of "tea", "tan", "ate", etc.
        // This is inefficient because we do many character comparisons
        //
        // Better: Hash map with sorted keys - O(n * k log k) time
        // Pseudocode:
        // 1. For each string, sort its characters to create a key
        // 2. Use this key to group anagrams in a HashMap
        // 3. Anagrams will have identical sorted keys
        // 4. Return all groups as final result
        
        // Hash map approach using sorted strings as keys - O(n * k log k) time complexity
        // Intuition: Anagrams have identical characters, so sorting creates same key
        // Example: "eat", "tea", "ate" all sort to "aet" → grouped together
        
        Map<String, List<String>> groups = new HashMap<>();

        // Process each string - O(n) strings
        for (String s : strs) {
            // Sort characters to create key - O(k log k) where k is string length
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            // Group strings by their sorted key
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        
        return new ArrayList<>(groups.values());
    }
}

/* BRUTE FORCE SOLUTION (for reference):
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;
            
            for (int j = i + 1; j < strs.length; j++) {
                if (!used[j] && areAnagrams(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(group);
        }
        
        return result;
    }
    
    private boolean areAnagrams(String s1, String s2) {
        // Character frequency comparison
    }
}
*/