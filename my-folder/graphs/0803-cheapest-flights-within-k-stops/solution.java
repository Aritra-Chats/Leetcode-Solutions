class Solution {
    private class Pair {
        int node, cost;
        private Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    private class Tuple {
        int node, cost, stops;
        private Tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Pair>[] adjList = new ArrayList[n];
        int[][] dist = new int[n][k+2];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int[] flight : flights) 
            adjList[flight[0]].add(new Pair(flight[1], flight[2]));
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.cost-b.cost));
        pq.offer(new Tuple(src, 0, 0));
        dist[src][0] = 0;
        while(!pq.isEmpty()) {
            Tuple node = pq.poll();
            if(node.cost > dist[node.node][node.stops]) continue;
            else if(node.node == dst) return node.cost;
            else if(node.stops >= k+1) continue;
            for(Pair neighbor : adjList[node.node]) {
                int newCost = node.cost + neighbor.cost;
                if(newCost < dist[neighbor.node][node.stops+1]) {
                    dist[neighbor.node][node.stops+1] = newCost;
                    pq.offer(new Tuple(neighbor.node, newCost, node.stops+1));
                }
            }
        }
        return -1;
    }
}
