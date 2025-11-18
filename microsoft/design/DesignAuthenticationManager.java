class AuthenticationManager {

    // THOUGHT PROCESS:
    // Track each token's expiry time in a map. Generating sets expiry, renewing updates expiry
    // only if the token is still valid, and counting scans expiry values to count unexpired tokens.
    // Time: O(1) for generate and renew, O(n) for count. Space: O(n) for the map.

    // PSEUDOCODE:
    // // 1. Store expiry times in a map from tokenId to expiryTime
    // // 2. To generate: set map[tokenId] = currentTime + ttl
    // // 3. To renew: if token exists and expiry > currentTime, update expiry to currentTime + ttl
    // // 4. To count: return number of map values greater than currentTime

    private int timeToLive;
    private Map<String, Integer> expiry = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        // expiry map from tokenId to expiryTime
        this.expiry = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        // create token with expiry currentTime + ttl
        expiry.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        // only renew if token exists and has not expired
        int exp = expiry.getOrDefault(tokenId, null);
        if (exp != null && exp > currentTime) {
            expiry.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        // count tokens whose expiry is strictly after currentTime
        int count = 0;
        for (int exp : expiry.values()) {
            if (exp > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */