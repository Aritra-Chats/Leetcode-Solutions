class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n], temp = new int[n]; 
        for(int i = 0; i < n; i++) 
            prev[i] = matrix[n-1][i];
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--)
                temp[j] = matrix[i][j] + Math.min(prev[j], 
                Math.min((j == 0) ? Integer.MAX_VALUE : prev[j - 1], (j == n - 1) ? Integer.MAX_VALUE : prev[j + 1]));
            prev = Arrays.copyOf(temp, n);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            min = Math.min(min, prev[i]);
        return min;
    }
}
