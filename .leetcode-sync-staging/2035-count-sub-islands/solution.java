class Solution {
    private boolean dfs(int i, int j, int m, int n, int[][] grid1, int[][] grid2, boolean[][] vis) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || vis[i][j])
                return true;
        vis[i][j] = true;
        boolean isSubIsland = grid1[i][j] == 1;
        int[] r = {1, 0, -1, 0}, c = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++) {
            int nr = i + r[k], nc = j + c[k];
            isSubIsland &= dfs(nr, nc, m, n, grid1, grid2, vis);
        }
        return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] != 0 && !vis[i][j])
                    if(dfs(i, j, m, n, grid1, grid2, vis))
                        count++;
            }
        }
        return count;
    }
}
