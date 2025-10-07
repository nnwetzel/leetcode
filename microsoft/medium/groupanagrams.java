class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Hash map approach using sorted strings as keys
        // Intuition: Anagrams have identical characters, so sorting creates same key
        // Example: "eat", "tea", "ate" all sort to "aet" → grouped together
        
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array for sorting
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            // Sorted string becomes the key (anagrams share same sorted form)
            String key = String.valueOf(chars);

            // Create new group if this sorted pattern hasn't been seen
            groups.putIfAbsent(key, new ArrayList<>());
            
            // Add original string to its anagram group
            groups.get(key).add(s);
        }
        
        // Return all anagram groups as a list
        return new ArrayList<>(groups.values());
    }
}