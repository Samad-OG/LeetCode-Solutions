 class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
         
        int[] dp = new int[n + 1];
        dp[0] = 1;  
      
        int[] lastPos = new int[26];
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int charIdx = c - 'a';
            
           
            dp[i] = (dp[i - 1] * 2) % MOD;
            
            
            if (lastPos[charIdx] > 0) {
                int prevIndex = lastPos[charIdx] - 1;
                dp[i] = (dp[i] - dp[prevIndex] + MOD) % MOD;
            }
             
            lastPos[charIdx] = i;
        }
       
        return (dp[n] - 1 + MOD) % MOD;
    }
}
