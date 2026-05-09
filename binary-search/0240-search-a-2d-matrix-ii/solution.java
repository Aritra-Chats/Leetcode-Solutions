class Solution {
    private boolean search(int[][] mat, int target, int r1, int r2, int c1, int c2) {
        if (r1 > r2 || c1 > c2) return false;
        int midCol = (c1 + c2) / 2;
        int lo = r1, hi = r2;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mat[mid][midCol] == target) 
                return true;
            else if (mat[mid][midCol] <  target) 
                lo = mid + 1;
            else                                 
                hi = mid - 1;
        }
        return search(mat, target, r1, hi, midCol + 1, c2) || search(mat, target, lo, r2, c1, midCol - 1);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
}
