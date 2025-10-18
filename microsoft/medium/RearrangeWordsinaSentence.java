import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String arrangeWords(String text) {
        // THOUGHT PROCESS:
        // Sort words by length while maintaining relative order - O(n log n) time
        // Pseudocode:
        // 1. Split text into words array
        // 2. Convert first word to lowercase (remove capitalization)
        // 3. Sort words by length (stable sort maintains original order for same lengths)
        // 4. Capitalize first letter of new first word
        // 5. Join words back into sentence
        
        String[] words = text.split(" ");
        
        // Remove capitalization from original first word
        words[0] = words[0].toLowerCase();
        
        // Sort by word length (shortest to longest)
        // Comparator.comparingInt(String::length) means: sort by each string's length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        // Capitalize first letter of new first word
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        
        return String.join(" ", words);
    }
}