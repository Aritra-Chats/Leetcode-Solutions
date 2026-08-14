class Solution {
    private int dfs(int currR, int currC, int maxR, int maxC, int[][] grid, boolean[][] vis) {
        int[] nr = {0, 1, 0, -1}, nc = {1, 0, -1, 0};
        vis[currR][currC] = true;
        int area = 1;
        for(int i = 0; i < 4; i++) {
            int r = currR + nr[i], c = currC + nc[i];
            if(r < 0 || r >= maxR || c < 0 || c >= maxC || grid[r][c] == 0 || vis[r][c])
                continue;
            area += dfs(r, c, maxR, maxC, grid, vis);
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxArea = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 || vis[i][j])
                    continue;
                maxArea = Math.max(maxArea, dfs(i, j, m, n, grid, vis));
            }
        }
        return maxArea;
    }
}
