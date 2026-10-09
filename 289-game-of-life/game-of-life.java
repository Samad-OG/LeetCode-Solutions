class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dirs = {-1, 0, 1};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(dirs[i] == 0 && dirs[j] == 0)) {
                            int r = row + dirs[i];
                            int c = col + dirs[j];

                            if (r >= 0 && r < m && c >= 0 && c < n) {
                                if (board[r][c] == 1 || board[r][c] == 2) {
                                    liveNeighbors++;
                                }
                            }
                        }
                    }
                }

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;
                } else if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                } else if (board[row][col] == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }
}
