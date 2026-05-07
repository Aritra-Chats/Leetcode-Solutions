class Solution {
    private void dfs(char[][] board, boolean[][] vis, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != 'O') return;
        vis[i][j] = true;
        dfs(board, vis, i-1, j);
        dfs(board, vis, i+1, j);
        dfs(board, vis, i, j-1);
        dfs(board, vis, i, j+1);
    }
    public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        int n = board[0].length;
        for(int i = 0; i < board.length; i++)  {
            dfs(board, vis, i, 0);
            dfs(board, vis, i, n-1);
        }
        for(int j = 0; j < n; j++)  {
            dfs(board, vis, 0, j);
            dfs(board, vis, board.length-1, j);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }
}
