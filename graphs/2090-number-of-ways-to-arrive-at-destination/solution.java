class Solution {
    private static final int MOD = 1_000_000_007;
    private class Pair {
        int node;
        long cost;
        private Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Pair>[] adjList = new ArrayList[n];
        long[] dist = new long[n];
        long[] ways = new long[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }
        for(int[] road : roads) {
            adjList[road[0]].add(new Pair(road[1], road[2]));
            adjList[road[1]].add(new Pair(road[0], road[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(0, 0));
        dist[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            if(node.cost > dist[node.node]) continue;
            for(Pair neighbor : adjList[node.node]) {
                long newCost = node.cost + neighbor.cost;
                if(newCost < dist[neighbor.node]) {
                    dist[neighbor.node] = newCost;
                    ways[neighbor.node] = ways[node.node];
                    pq.offer(new Pair(neighbor.node, newCost));
                } else if(newCost == dist[neighbor.node])
                    ways[neighbor.node] = (ways[neighbor.node] + ways[node.node]) % MOD;
            }
        }
        return (int)(ways[n-1] % MOD);
    }
}
