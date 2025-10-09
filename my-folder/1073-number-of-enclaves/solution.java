class Solution {
    private void dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] != 1) 
            return;
        vis[i][j] = true;
        dfs(grid, vis, i-1, j);
        dfs(grid, vis, i+1, j);
        dfs(grid, vis, i, j-1);
        dfs(grid, vis, i, j+1);
    }
    public int numEnclaves(int[][] grid) {
        int n = grid[0].length;
        boolean[][] vis = new boolean[grid.length][n];
        for(int i = 0; i < grid.length; i++) {
            dfs(grid, vis, i, 0);
            dfs(grid, vis, i, n-1);
        }
        for(int j = 0; j < n; j++) {
            dfs(grid, vis, 0, j);
            dfs(grid, vis, grid.length-1, j);
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1 && !vis[i][j]) count++;
        return count;
    }
}
