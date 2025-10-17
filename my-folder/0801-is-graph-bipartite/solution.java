class Solution {
    private boolean dfs(int node, int currColor, int[][] graph, int[] color) {
        if(color[node] != -1) return color[node] == currColor;
        color[node] = currColor;
        for(int i = 0; i < graph[node].length; i++) {
            if(!dfs(graph[node][i], (currColor+1) % 2, graph, color))
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) 
                if(!dfs(i, 0, graph, color))
                    return false;
        }
        return true;
    }
}
