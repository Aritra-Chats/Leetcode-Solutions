class Solution {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length < 2) return isConnected.length;
        int provinces = 0;
        vis = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                provinces++;
                vis[i] = true;
                visitConnectedCities(i, isConnected);
            }
        }
        return provinces;
    }
    public void visitConnectedCities(int city, int[][] isConnected) {
        for(int i = 0; i < isConnected.length; i++)
            if(isConnected[city][i] == 1 && !vis[i]) {
                vis[i] = true;
                visitConnectedCities(i, isConnected);
            }
    }
}
