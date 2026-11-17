import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }
        
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j, divisors[j - i + 1]);
            }
        }
        
        int INF = 1_000_000;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[m][p - 1] != INF) {
                        dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
    private int getSemiPalindromeCost(String s, int start, int end, List<Integer> divs) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;
        
        for (int d : divs) {
            int changes = 0;
            int groupLen = len / d;
            for (int offset = 0; offset < d; offset++) {
                int left = 0;
                int right = groupLen - 1;
                while (left < right) {
                    if (s.charAt(start + offset + left * d) != s.charAt(start + offset + right * d)) {
                        changes++;
                    }
                    left++;
                    right--;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        
        return minChanges;
    }
}
