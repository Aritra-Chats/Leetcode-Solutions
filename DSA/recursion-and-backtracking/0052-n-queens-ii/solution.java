class Solution {
    private boolean checkPositions(int row, int col, int[] queens) {
        for(int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            if(prevCol == col || Math.abs(prevRow - row) == Math.abs(prevCol - col))
                return false;
        }
        return true;
    }
    private int countPossiblePositions(int row, int n, int[] queens) {
        int possibleArrangements = 0;
        for(int col = 0; col < n; col++) {
            if(checkPositions(row, col, queens)) {
                if(row == n-1)
                    possibleArrangements++;
                else {
                    queens[row] = col;
                    possibleArrangements += countPossiblePositions(row+1, n, queens);
                }
            }
        }
        queens[row] = 0;
        return possibleArrangements;
    }
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        return countPossiblePositions(0, n, queens);
    }
}
