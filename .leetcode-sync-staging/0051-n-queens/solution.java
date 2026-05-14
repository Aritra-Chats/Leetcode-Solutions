class Solution {
    private boolean isValid(int row, int col, int[] assigned) {
        for(int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = assigned[prevRow];
            if(prevCol == col || Math.abs(row - prevRow) == Math.abs(col - prevCol))
                return false;
        }
        return true;
    }
    private void assignQueens(int row, String[] rows, int n, List<String> iterator, List<List<String>> queens, int[] assigned) {
        if(row == n) {
            queens.add(new ArrayList<>(iterator));
        }
        for(int col = 0; col < n; col++) {
            if(!isValid(row, col, assigned))
                continue;
            iterator.add(rows[col]);
            assigned[row] = col;
            assignQueens(row + 1, rows, n, iterator, queens, assigned);
            assigned[row] = -1;
            iterator.remove(iterator.size() - 1);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        String[] rows = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) 
                sb.append((j == i) ? 'Q' : '.');
            rows[i] = sb.toString();
        }
        List<List<String>> queens = new ArrayList<>();
        int[] assigned = new int[n];
        Arrays.fill(assigned, -1);
        assignQueens(0, rows, n, new ArrayList<>(), queens, assigned);
        return queens;
    }
}
