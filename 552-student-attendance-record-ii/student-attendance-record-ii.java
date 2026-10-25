class Solution {
    public int checkRecord(int n) {
        long MOD = 1000000007;
        long[][] dp = new long[2][3];
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            long[][] nextDp = new long[2][3];
            
            long sumA0 = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            long sumA1 = (dp[1][0] + dp[1][1] + dp[1][2]) % MOD;
            
            nextDp[0][0] = sumA0;
            nextDp[1][0] = (sumA1 + sumA0) % MOD;
            
            nextDp[0][1] = dp[0][0];
            nextDp[0][2] = dp[0][1];
            
            nextDp[1][1] = dp[1][0];
            nextDp[1][2] = dp[1][1];
            
            dp = nextDp;
        }
        
        long total = 0;
        for (int a = 0; a < 2; a++) {
            for (int l = 0; l < 3; l++) {
                total = (total + dp[a][l]) % MOD;
            }
        }
        
        return (int) total;
    }
}
