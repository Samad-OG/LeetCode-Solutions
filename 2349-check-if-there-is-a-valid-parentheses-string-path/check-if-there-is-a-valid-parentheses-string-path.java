class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        boolean[][][] dp = new boolean[m][n][(m + n) / 2 + 1];
        
        if (grid[0][0] == ')') {
            return false;
        }
        dp[0][0][1] = true;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = (grid[i][j] == '(') ? 1 : -1;
                
                for (int b = 0; b <= (m + n) / 2; b++) {
                    if (!dp[i][j][b]) continue;
                    
                    if (i + 1 < m) {
                        int nextB = b + ((grid[i + 1][j] == '(') ? 1 : -1);
                        if (nextB >= 0 && nextB <= (m + n - 1 - (i + 1 + j))) {
                            dp[i + 1][j][nextB] = true;
                        }
                    }
                    
                    if (j + 1 < n) {
                        int nextB = b + ((grid[i][j + 1] == '(') ? 1 : -1);
                        if (nextB >= 0 && nextB <= (m + n - 1 - (i + j + 1))) {
                            dp[i][j + 1][nextB] = true;
                        }
                    }
                }
            }
        }
        
        return dp[m - 1][n - 1][0];
    }
}
