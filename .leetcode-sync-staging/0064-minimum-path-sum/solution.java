class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n], temp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    temp[j] = grid[i][j];
                else
                    temp[j] = Math.min((i == 0) ? Integer.MAX_VALUE : prev[j], (j == 0) ? Integer.MAX_VALUE : temp[j-1]) + grid[i][j];
            }
            prev = Arrays.copyOf(temp, n);
        }
        return prev[n-1];
    }
}
