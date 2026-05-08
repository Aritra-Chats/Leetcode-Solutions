class Solution {
    private boolean hasWord(int r, int c, char[][] board, int wrdIdx, String word, boolean[][] vis, int[][] pd, int rows, int cols) {
        if(board[r][c] != word.charAt(wrdIdx))
            return false;
        if(wrdIdx == word.length() - 1)
            return true;
        vis[r][c] = true;
        for(int[] d : pd) {
            int nr = r + d[0], nc = c + d[1];
            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || vis[nr][nc])
                continue;
            if(hasWord(nr, nc, board, wrdIdx + 1, word, vis, pd, rows, cols))
                return true;
        }
        vis[r][c] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        int[][] pd = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] vis = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(hasWord(i, j, board, 0, word, vis, pd, rows, cols))
                        return true;
                }
            }
        }
        return false;
    }
}
