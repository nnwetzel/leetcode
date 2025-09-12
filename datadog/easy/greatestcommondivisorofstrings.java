class Solution {
    // Explain Euclidean algorithm: gcd(x,y) == gcd(y, x % y); terminates when y == 0
    public int gcd(int x, int y) {
        if (y == 0) return x;      // Base case: when remainder is 0, x is the gcd
        return gcd(y, x % y);      // Recursive step: reduce problem size via modulo
    }
    
    public String gcdOfStrings(String str1, String str2) {
        // Justify concatenation check: if both are made of the same base pattern,
        // str1+str2 == str2+str1; otherwise no common divisor string exists
        if (!(str1 + str2).equals(str2 + str1)) return "";

        // Explain why gcd of lengths works:
        // If both strings are k-times repeats of some base, the base length must divide both lengths
        int len = gcd(str1.length(), str2.length());

        // Argue correctness: the prefix of length gcd(len1,len2) is that common base pattern
        return str1.substring(0, len);
    }
}