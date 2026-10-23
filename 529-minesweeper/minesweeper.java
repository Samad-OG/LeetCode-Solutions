class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        
        dfs(board, r, c);
        return board;
    }
    
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }
        
        int mines = countMines(board, r, c);
        
        if (mines > 0) {
            board[r][c] = (char) (mines + '0');
        } else {
            board[r][c] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    dfs(board, r + i, c + j);
                }
            }
        }
    }
    
    private int countMines(char[][] board, int r, int c) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nr = r + i;
                int nc = c + j;
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if (board[nr][nc] == 'M') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
