class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], row = curr[1], col = curr[2];
            if(row == heights.length-1 && col == heights[0].length-1)
                return d;
            for(int i = 0; i < 4; i++) {
                int r = row + dr[i], c = col + dc[i];
                if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) 
                    continue;
                int newEffort = Math.max(d, Math.abs(heights[row][col]-heights[r][c]));
                if(newEffort < dist[r][c]) {
                    dist[r][c] = newEffort;
                    pq.offer(new int[]{newEffort, r, c});
                }
            }
        }
        return 0;
    }
}
