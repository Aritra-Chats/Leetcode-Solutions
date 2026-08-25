class Solution {
    private class Pair {
        int v;
        double prob;
        private Pair(int v, double prob) {
            this.v = v;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adjList = new ArrayList<>();
        List<Double> probFromStart = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            if(i == start_node)
                probFromStart.add(1.0);
            else
                probFromStart.add(0.0);
        }
        int len = edges.length;
        for(int i = 0; i < len; i++) {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start_node, 1.0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u =curr.v;
            double currProb = curr.prob;
            for(Pair node : adjList.get(u)) {
                double nextProb = currProb * node.prob;
                if(nextProb > probFromStart.get(node.v)) {
                    probFromStart.set(node.v, nextProb);
                    pq.offer(new Pair(node.v, nextProb));
                }
            }
        }
        return probFromStart.get(end_node);
    }
}
