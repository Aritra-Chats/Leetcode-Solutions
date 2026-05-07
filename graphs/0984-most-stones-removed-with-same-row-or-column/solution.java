class Solution {
    private class DisjointSet {
        int[] parent, rank;
        int size;
        private DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.size = 0;
            for(int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 0;
            }
        }
        int findParent(int x) {
            if(parent[x] == x) return x;
            else {
                parent[x] = findParent(parent[x]);
                return parent[x];
            }
        }
        void union(int x, int y) {
            int px = findParent(x), py = findParent(y);
            if(px == py) return;
            if(rank[px] < rank[py]) 
                parent[px] = py;
            else if(rank[px] > rank[py])
                parent[py] = px;
            else if(rank[px] == rank[py]) {
                rank[px]++;
                parent[py] = px;
            }
            size++;
        }
    }
    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(stones.length);
        for(int i = 0; i < stones.length; i++) {
            for(int j = i+1; j < stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) 
                    ds.union(i, j);
            }
        }
        return ds.size;
    }
}
