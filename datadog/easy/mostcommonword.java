class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // Clean the paragraph:
        // Replace all non-letter characters with spaces, then convert everything to lowercase
        String cleanParagraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        
        // Split the cleaned paragraph into individual words using whitespace as the delimiter
        String[] words = cleanParagraph.split("\\s+");

        // Create a HashSet for banned words for quick lookup
        HashSet<String> bannedSet = new HashSet<String>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }
        
        // Create a HashMap to count frequencies of non-banned words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            // Skip the word if it is in the banned list
            if (!bannedSet.contains(word)) {
                if (map.containsKey(word)) {
                    // If the word is already in the map, increment its count
                    map.put(word, map.get(word) + 1);
                } else {
                    // If it's the first time we've seen the word, set count to 1
                    map.put(word, 1);
                }
            }
        }

        // Find the word with the highest count in the map
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
