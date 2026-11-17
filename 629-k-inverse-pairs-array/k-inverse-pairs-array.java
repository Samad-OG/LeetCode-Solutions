class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                long val = (long) dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) {
                    val = (val - dp[i - 1][j - i] + MOD) % MOD;
                } else {
                    val %= MOD;
                }
                dp[i][j] = (int) val;
            }
        }
        
        return dp[n][k];
    }
}
