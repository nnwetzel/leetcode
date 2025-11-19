class Solution {

    // THOUGHT PROCESS:
    // Use the Sieve of Eratosthenes to mark composites and count primes below n.
    // For each number, if it’s prime, we cross out all of its multiples to isolate the primes.
    // Time: O(n log log n). Space: O(n).

    // PSEUDOCODE:
    // 1. If n is two or less return zero because there are no primes below two
    // 2. Make a boolean array isPrime of size n and assume numbers from two upward are prime
    // 3. For i starting at two while i is at most the square root of n:
    //   - If i is still marked prime, mark every multiple of i starting at i squared as not prime
    // 4. Count how many entries from two up to n minus one remain marked prime and return that count

    public int countPrimes(int n) {
        // n is looking for primes strictly less than n
        // we know 0 and 1 are not prime
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // only need to check factors up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            // if i is prime, mark its multiples as not prime
            if (isPrime[i]) {
                // start marking at i^2, as smaller multiples were marked by smaller factors
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        // count primes from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}