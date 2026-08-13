class Solution {
    private void dfs(int currR, int currC, int maxR, int maxC, char[][] grid, boolean[][] vis) {
        if(currR < 0 || currR >= maxR || currC < 0 || currC >= maxC || vis[currR][currC] || grid[currR][currC] == '0')
            return;
        vis[currR][currC] = true;
        int[] nr = {0, 1, 0, -1}, nc = {1, 0, -1, 0};
        for(int i = 0; i < 4; i++) 
            dfs(currR + nr[i], currC + nc[i], maxR, maxC, grid, vis);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] || grid[i][j] == '0')
                    continue;
                dfs(i, j, m, n, grid, vis);
                count++;
            }
        }
        return count;
    }
}
