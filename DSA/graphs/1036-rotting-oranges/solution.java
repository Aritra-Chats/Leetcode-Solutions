class Solution {
    private class Pair {
        int row, col;
        Pair() {
            this.row = -1;
            this.col = -1;
        }
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for(int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                if(curr.row > 0 && grid[curr.row-1][curr.col] == 1) {
                    grid[curr.row-1][curr.col] = 2;
                    queue.offer(new Pair(curr.row-1, curr.col));
                    rotted = true;
                }
                if(curr.row < grid.length-1 && grid[curr.row+1][curr.col] == 1) {
                    grid[curr.row+1][curr.col] = 2;
                    queue.offer(new Pair(curr.row+1, curr.col));
                    rotted = true;
                }
                if(curr.col > 0 && grid[curr.row][curr.col-1] == 1) {
                    grid[curr.row][curr.col-1] = 2;
                    queue.offer(new Pair(curr.row, curr.col-1));
                    rotted = true;
                }
                if(curr.col < grid[curr.row].length-1 && grid[curr.row][curr.col+1] == 1) {
                    grid[curr.row][curr.col+1] = 2;
                    queue.offer(new Pair(curr.row, curr.col+1));
                    rotted = true;
                }
            }
            if(rotted) time++;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}
