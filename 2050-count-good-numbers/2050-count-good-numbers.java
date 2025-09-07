class Solution {
    private static final long MOD = 1_000_000_007L;

    private long modPow(long base, long exp) {
        base %= MOD;               // reduce base first
        long result = 1L;
        while (exp > 0) {
            if ((exp & 1L) == 1L) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long part1 = modPow(5L, (n + 1) / 2); // positions that allow 5 choices
        long part2 = modPow(4L, n / 2);       // positions that allow 4 choices
        return (int) ((part1 * part2) % MOD);
    }
}