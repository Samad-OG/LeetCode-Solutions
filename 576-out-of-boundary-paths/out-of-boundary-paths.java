class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0) return 0;
        
        int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int moves = 1; moves <= maxMove; moves++) {
            int[][] nextDp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                count = (count + dp[r][c]) % MOD;
                            } else {
                                nextDp[nr][nc] = (nextDp[nr][nc] + dp[r][c]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }
        
        return count;
    }
}
