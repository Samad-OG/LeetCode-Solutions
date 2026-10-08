 class Solution {
    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return superPowHelper(a, b, b.length - 1);
    }

    private int superPowHelper(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        
        int lastDigit = b[index];
        int part1 = powMod(a, lastDigit);
        int part2 = powMod(superPowHelper(a, b, index - 1), 10);
        
        return (part1 * part2) % MOD;
    }

    private int powMod(int base, int exp) {
        base %= MOD;
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
