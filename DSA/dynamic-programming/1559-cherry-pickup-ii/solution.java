class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] prev = new int[n][n];
        for(int j1 = 0; j1 < n; j1++)
            for(int j2 = 0; j2 < n; j2++)
                prev[j1][j2] = (j1 == j2) ? grid[m-1][j1] : grid[m-1][j1] + grid[m-1][j2];
        for(int i = m - 2; i >= 0; i--) {
            int[][] temp = new int[n][n];
            for(int j1 = 0; j1 < n; j1++) {
                for(int j2 = 0; j2 < n; j2++) {
                    int val = Integer.MIN_VALUE;
                    for(int d1 = -1; d1 <= 1; d1++) {
                        for(int d2 = -1; d2 <= 1; d2++) {
                            int nj1 = j1 + d1, nj2 = j2 + d2;
                            if(nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n)
                                val = Math.max(val, prev[nj1][nj2]);
                        }
                    }
                    temp[j1][j2] = ((j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2]) + val;
                }
            }
            prev = temp;
        }
        return prev[0][n-1];
    }
}
