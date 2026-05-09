class Solution {
    public static int findMax(int[][] arr, int m, int mid){
        int maxi = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i < m; i++){
            if(arr[i][mid] > maxi){
                maxi = arr[i][mid];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length, low = 0, high = n - 1;
        while(low <= high) {
            int mid = (low + high) / 2, maxR = findMax(mat, m, mid);
            int left = (mid - 1 < 0) ? Integer.MIN_VALUE : mat[maxR][mid - 1], right = (mid + 1 < n) ? mat[maxR][mid + 1] : Integer.MIN_VALUE;
            if(mat[maxR][mid] > left && mat[maxR][mid] > right)
                return new int[]{maxR, mid};
            else if(mat[maxR][mid] <= left)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
