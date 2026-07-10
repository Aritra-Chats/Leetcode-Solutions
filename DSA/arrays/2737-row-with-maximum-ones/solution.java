class Solution {
    private int hasOnesInRow(int[] oneCount, int mid, int m) {
        for(int i = 0; i < m; i++)
            if(oneCount[i] >= mid)
                return i;
        return -1;
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length; 
        int[] oneCount = new int[m];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(mat[i][j] == 1)
                    oneCount[i]++;
        int low = 1, high = n, ans = 0;
        while(low <= high) {
            int mid = (low + high) / 2, row = hasOnesInRow(oneCount, mid, m);
            if(row != -1) {
                ans = row;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return new int[]{ans, high};
    }
}
