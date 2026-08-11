class Solution {
    private boolean isValidElement(char[][] board, int currR, int currC, int maxR, int maxC) {
        for(int i = 0; i < maxR; i++) {
            if(i == currR)
                continue;
            if(board[i][currC] == board[currR][currC])
                return false;
        }
        for(int i = 0; i < maxC; i++) {
            if(i == currC)
                continue;
            if(board[currR][i] == board[currR][currC])
                return false;
        }
        int startR = (currR / 3) * 3, startC = (currC / 3) * 3;
        for(int i = startR; i < startR + 3; i++) {
            for(int j = startC; j < startC + 3; j++) {
                if( i == currR && j == currC)
                    continue;
                if(board[i][j] == board[currR][currC])
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.')
                    continue;
                if(!isValidElement(board, i, j, m, n))
                    return false;
            }
        }
        return true;
    }
}
