class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n], temp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    temp[j] = 1;
                else
                    temp[j] = ((j == 0) ? 0 : temp[j-1]) + ((i == 0) ? 0 : prev[j]);
            }
            prev = Arrays.copyOf(temp, n);
        }
        return prev[n-1];
    }
}
