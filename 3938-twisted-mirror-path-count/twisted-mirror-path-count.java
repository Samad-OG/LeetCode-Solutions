import java.util.*;

class Solution {
    private int m;
    private int n;
    private int[][] memo;
    private static final int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, grid);
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long res = 0;

        int ni = i, nj = j + 1;
        int curr_d = 0; 
        while (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
            if (curr_d == 0) {
                ni++;
                curr_d = 1;
            } else {
                nj++;
                curr_d = 0;
            }
        }
        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            res = (res + dfs(ni, nj, grid)) % MOD;
        }

        ni = i + 1;
        nj = j;
        curr_d = 1; 
        while (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
            if (curr_d == 0) {
                ni++;
                curr_d = 1;
            } else {
                nj++;
                curr_d = 0;
            }
        }
        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            res = (res + dfs(ni, nj, grid)) % MOD;
        }

        memo[i][j] = (int) res;
        return memo[i][j];
    }
}
