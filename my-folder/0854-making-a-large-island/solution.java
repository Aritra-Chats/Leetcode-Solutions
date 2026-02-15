class Solution {
    private class DisjointSet {
        int[] parent, size;
        private DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) return;
            if(size[py] > size[px]) {
                size[py] += size[px];
                parent[px] = py;
            } else {
                size[px] += size[py];
                parent[py] = px;
            }
        }
    }
    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length * grid[0].length);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
                    for(int k = 0; k < 4; k++) 
                        if((i+dr[k]) >= 0 && (i+dr[k]) < grid.length && (j+dc[k]) >= 0 && (j+dc[k]) < grid.length) 
                            if(grid[i+dr[k]][j+dc[k]] == 1) ds.union(i * grid[0].length + j, (i+dr[k]) * grid[0].length + (j+dc[k]));
                }
            }
        }
        int maxIslandSize = 0;
        boolean hasZero = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    hasZero = true;
                    int currentIslandSize = 1;
                    int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
                    for(int k = 0; k < 4; k++) 
                        if((i+dr[k]) >= 0 && (i+dr[k]) < grid.length && (j+dc[k]) >= 0 && (j+dc[k]) < grid.length) 
                            if(grid[i+dr[k]][j+dc[k]] == 1 && seen.add(ds.find((i+dr[k]) * grid[0].length + (j+dc[k])))) currentIslandSize += ds.size[ds.find((i+dr[k]) * grid[0].length + (j+dc[k]))];
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }
        if(hasZero) return maxIslandSize;
        else {
            int ans = 0;
            for(int i = 0;i < grid.length * grid[0].length; i++)
                if(ds.find(i) == i)
                    ans = Math.max(ans, ds.size[i]);
            return ans;
        }
    }
}
