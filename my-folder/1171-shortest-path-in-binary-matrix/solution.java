class Solution {
    private class Pair {
        int r, c;
        private Pair(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];
        q.offer(new Pair(0, 0));
        vis[0][0] = true;
        int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair node = q.poll();
                if(node.r == n-1 && node.c == n-1) 
                    return dist;
                for(int j = 0; j < 8; j++) {
                    if(node.r + dr[j] < 0 || node.r + dr[j] >= grid.length || node.c + dc[j] < 0 || node.c + dc[j] >= grid.length)
                        continue;
                    if(grid[node.r + dr[j]][node.c + dc[j]] == 0 && !vis[node.r + dr[j]][node.c + dc[j]]) {
                        q.offer(new Pair(node.r + dr[j], node.c + dc[j]));
                        vis[node.r + dr[j]][node.c + dc[j]] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
