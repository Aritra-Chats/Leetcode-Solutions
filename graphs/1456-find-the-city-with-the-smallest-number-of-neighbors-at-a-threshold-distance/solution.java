class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        for(int i = 0; i < n; i++)
            dist[i][i] = 0;
        for(int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j || i == k || j == k || dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int result = -1, minCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold)
                    count++;
            }
            if(count < minCount || (count == minCount && i > result)) {
                minCount = count;
                result = i;
            }
        }
        return result;
    }
}
