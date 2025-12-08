class Solution {
    private boolean DFSCheck(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for(int i : graph[node]) {
            if(!vis[i]) {
                if(DFSCheck(i, graph, vis, pathVis, check))
                    return true;
            } else if(pathVis[i])
                return true;
        }
        check[node] = true;
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] check = new boolean[graph.length], vis = new boolean[graph.length], pathVis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) 
            if(!vis[i])
                DFSCheck(i, graph, vis, pathVis, check);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < graph.length; i++)
            if(check[i]) result.add(i);
        return result;
    }
}
