class Solution {
    private boolean[][] pacific(int m, int n, int[][] heights) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < n; i++) {
            vis[0][i] = true;
            queue.offer(new int[]{0, i});
        }
        for(int i = 1; i < m; i++) {
            vis[i][0] = true;
            queue.offer(new int[]{i, 0});
        }
        int[] r = {1, 0, -1, 0}, c = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            for(int k = 0; k < 4; k++) {
                int nr = i + r[k], nc = j + c[k];
                if(nr<0 || nr>=m || nc<0 || nc>=n || vis[nr][nc] || heights[nr][nc]<heights[i][j])
                    continue;
                vis[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        return vis;
    }
    private boolean[][] atlantic(int m, int n, int[][] heights) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for(int i = n-1; i >= 0; i--) {
            vis[m-1][i] = true;
            queue.offer(new int[]{m-1, i});
        }
        for(int i = m-2; i >= 0; i--) {
            vis[i][n-1] = true;
            queue.offer(new int[]{i, n-1});
        }
        int[] r = {1, 0, -1, 0}, c = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            for(int k = 0; k < 4; k++) {
                int nr = i + r[k], nc = j + c[k];
                if(nr<0 || nr>=m || nc<0 || nc>=n || vis[nr][nc] || heights[nr][nc]<heights[i][j])
                    continue;
                vis[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        return vis;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = pacific(m, n, heights), atlantic = atlantic(m, n, heights);
        int[] r = {1, 0, -1, 0}, c = {0, 1, 0, -1};
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    results.add(List.of(i, j));
            }
        }
        return results;
    }
}
