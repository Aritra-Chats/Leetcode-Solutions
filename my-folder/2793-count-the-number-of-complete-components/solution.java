class Solution {
    boolean[] vis;
    List<List<Integer>> adj;
    private void dfs(int node, List<Integer> component) {
        vis[node] = true;
        component.add(node);
        List<Integer> list = adj.get(node);
        for(int num : list)
            if(!vis[num]) dfs(num, component);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        if(n == 0) return 0;
        if(n == 1 || n != 0 && edges.length == 0) return n;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int completeComponents = 0;
        vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(vis[i]) continue;
            List<Integer> component = new ArrayList<>();
            dfs(i, component);
            boolean isComplete = true;
            int size = component.size();
            for(int node : component) {
                if(adj.get(node).size() != size - 1) {
                    isComplete = false;
                    break;
                }
            }
            if(isComplete) completeComponents++;
        }
        return completeComponents;
    }
}
