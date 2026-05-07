class Solution {
    private static class DisjointSet {
        int[] parent, size;
        int extra = 0;
        private DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
            if(px == py) {
                extra++;
                return;
            }
            if(size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        for(int[] connection : connections)
            ds.union(connection[0], connection[1]);
        Set<Integer> unconnected = new HashSet<>();
        for(int i = 0; i < n; i++)
            unconnected.add(ds.findParent(i));
        return ds.extra < (unconnected.size()-1) ? -1 : unconnected.size()-1;
    }
}
