class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                if(node[0] == n-1 && node[1] == n-1) 
                    return dist;
                for(int j = 0; j < 8; j++) {
                    if(node[0] + dr[j] < 0 || node[0] + dr[j] >= grid.length || node[1] + dc[j] < 0 || node[1] + dc[j] >= grid.length)
                        continue;
                    if(grid[node[0] + dr[j]][node[1] + dc[j]] == 0 && !vis[node[0] + dr[j]][node[1] + dc[j]]) {
                        q.offer(new int[]{node[0] + dr[j], node[1] + dc[j]});
                        vis[node[0] + dr[j]][node[1] + dc[j]] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
