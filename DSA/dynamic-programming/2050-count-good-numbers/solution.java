class Solution {
    private static final long MOD = 1_000_000_007;

    private long power(long x, long n) {
        long result = 1;
        while(n > 0) {
            if((n & 1) == 1)
                result = (result * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        return (int)((power(5, (n + 1) / 2) * power(4, n / 2)) % MOD);
    }
}
