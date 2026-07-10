class Solution {
    private class DisjointSet {
        int[] parent, rank;
        private DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) return;
            if(rank[px] > rank[py]) parent[py] = px;
            else if(rank[py] > rank[px]) parent[px] = py;
            else {
                rank[px]++;
                parent[py] = px;
            }
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length * grid[0].length;
        DisjointSet ds = new DisjointSet(n);
        int[][] levels = new int[n][3];
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                levels[i * grid[0].length + j] = new int[]{grid[i][j], i, j};
        Arrays.sort(levels, (a, b) -> (a[0]-b[0]));
        boolean[][] active = new boolean[grid.length][grid[0].length];
        int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
        for(int[] level : levels) {
            int h = level[0], r = level[1], c = level[2];
            active[r][c] = true;
            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && active[nr][nc])
                    ds.union(r * grid[0].length + c, nr * grid[0].length + nc);
            }
            if(ds.find(0) == ds.find((grid.length-1) * grid[0].length + (grid[0].length-1)))
                return h;
        }
        return -1;
    }
}
