class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // Preprocessing step: normalize text
        // Replace punctuation with spaces and lowercase everything
        String cleanParagraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        
        // Tokenization: split on whitespace into individual words
        String[] words = cleanParagraph.split("\\s+");

        // Banned words lookup structure — O(1) average time for contains()
        HashSet<String> bannedSet = new HashSet<String>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }
        
        // Frequency map to count non-banned words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            // Skip banned words
            if (!bannedSet.contains(word)) {
                // Increment count if seen before, otherwise start at 1
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Find the most frequent non-banned word
        int max = 0;
        String maxWord = "";
        for (String word : map.keySet()) {
            int count = map.get(word);
            if (count > max) {
                max = count;
                maxWord = word;
            }
        }

        return maxWord;
    }
}