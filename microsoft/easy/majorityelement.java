class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        // Intuition: Count majority element instances as +1 and others as -1
        // The majority element will always have a positive net count
        
        int count = 0;
        Integer candidate = null;

        // Find candidate for majority element
        for (int num : nums) {
            // When count reaches 0, we "forget" the previous prefix
            // and consider current element as new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // Increment count for candidate, decrement for others
            if (num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        // Algorithm works because we can safely discard prefixes where
        // count reaches 0, as they contain equal numbers of majority/minority elements
        return candidate;
    }
}