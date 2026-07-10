class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] prev = new int[n];
        for(int i = m-1; i >= 0; i--) {
            int[] temp = new int[n];
            for(int j = n-1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1)
                    continue;
                else if(i == m - 1 && j == n - 1)
                    temp[j] = 1;
                else
                    temp[j] = ((j == n - 1) ? 0 : temp[j+1]) + ((i == m - 1) ? 0 : prev[j]);
            }
            prev = temp;
        }
        return prev[0];
    }
}
