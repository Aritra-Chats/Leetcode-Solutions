class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] result = new int[m][n];
        int MAX = m+n;
        for(int i = 0; i < isWater.length; i++) {
            for(int j = 0; j < n; j++)
                result[i][j] = (isWater[i][j] == 1) ? 0 : MAX;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(result[i][j] != 0) {
                    if(i > 0) result[i][j] = Math.min(result[i][j], 1 + result[i-1][j]);
                    if(j > 0) result[i][j] = Math.min(result[i][j], 1 + result[i][j-1]);
                }
            }
        }
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(result[i][j] != 0) {
                    if(i < m-1) result[i][j] = Math.min(result[i][j], 1 + result[i+1][j]);
                    if(j < n-1) result[i][j] = Math.min(result[i][j], 1 + result[i][j+1]);
                }
            }
        }
        return result;
    }
}
