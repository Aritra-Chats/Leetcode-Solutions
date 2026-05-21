class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        int[] prev = new int[n];
        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                if(i == 0 && j == 0)
                    temp[j] = 1;
                else
                    temp[j] = ((i == 0) ? 0 : prev[j]) + ((j == 0) ? 0 : temp[j-1]);
            }
            prev = Arrays.copyOf(temp, n);
        }
        return prev[n-1];
    }
}
