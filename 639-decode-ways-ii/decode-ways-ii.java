class Solution {
    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        long prev2 = 1;
        long prev1 = ways(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            long curr = (prev1 * ways(s.charAt(i))) % MOD;
            curr = (curr + prev2 * ways(s.charAt(i - 1), s.charAt(i))) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return (int) prev1;
    }

    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private int ways(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            return c2 <= '6' ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') return 9;
            if (c1 == '2') return 6;
            return 0;
        }
        int val = (c1 - '0') * 10 + (c2 - '0');
        return (val >= 10 && val <= 26) ? 1 : 0;
    }
}
