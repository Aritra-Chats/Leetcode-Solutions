class Solution {
    private void dfs(int idx, int parent, int timer, List<List<Integer>> adj, int[] time, int[] low, boolean[] vis, List<List<Integer>> bridges) {
        time[idx] = low[idx] = timer++;
        vis[idx] = true;
        for(int child : adj.get(idx)) {
            if(child == parent) continue;
            if(!vis[child]) {
                dfs(child, idx, timer, adj, time, low, vis, bridges);
                low[idx] = Math.min(low[idx], low[child]);
                if(low[child] > time[idx]) bridges.add(new ArrayList<>(List.of(idx, child)));
            }
            else if(child != parent) 
                low[idx] = Math.min(low[idx], time[child]);
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] time = new int[n], low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        for(List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i=0; i < n; i++)
            if(!vis[i]) dfs(i, -1, 1, adj, time, low, vis, bridges);
        return bridges;
    }
}
