class Solution {
    private class UnionFind {
        int[] rank, parent;
        private UnionFind(int nodes) {
            rank = new int[nodes];
            parent = new int[nodes];
            for(int i = 0; i < nodes; i++)
                parent[i] = i;
        }
        void union(int u, int v) {
            int pu = find(u), pv = find(v);
            if(pu == pv)
                return; 
            else if(rank[pu] > rank[pv])
                parent[pv] = pu;
            else if(rank[pv] > rank[pu])
                parent[pu] = pv;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
        int find(int node) {
            if(parent[node] != node)
                parent[node] = find(parent[node]);
            return parent[node];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = 0;
        for(int[] edge : edges)
            nodes = Math.max(nodes, Math.max(edge[0], edge[1]));
        UnionFind uf = new UnionFind(nodes+1);
        int[] result = new int[2];
        for(int[] edge : edges) {
            if(uf.find(edge[0]) == uf.find(edge[1])) {
                result = edge;
                break;
            }
            uf.union(edge[0], edge[1]);
        }
        return result;
    }
}
