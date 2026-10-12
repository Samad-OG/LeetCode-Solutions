import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, cols - 1, heights[i][cols - 1]);
        }
        
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, rows - 1, j, heights[rows - 1][j]);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int prevHeight) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        
        ocean[r][c] = true;
        
        dfs(heights, ocean, r + 1, c, heights[r][c]);
        dfs(heights, ocean, r - 1, c, heights[r][c]);
        dfs(heights, ocean, r, c + 1, heights[r][c]);
        dfs(heights, ocean, r, c - 1, heights[r][c]);
    }
}
