class Solution {
    private class Pair {
        int node, time;
        private Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adjList = new ArrayList[n];
        int[] timeTaken = new int[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            timeTaken[i] = Integer.MAX_VALUE;
        }
        for(int[] time : times) 
            adjList[time[0]-1].add(new Pair(time[1]-1, time[2]));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.time-b.time));
        pq.offer(new Pair(k-1, 0));
        timeTaken[k-1] = 0;
        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            for(Pair neighbor : adjList[node.node]) {
                int time = node.time + neighbor.time;
                if(time < timeTaken[neighbor.node]) {
                    timeTaken[neighbor.node] = time;
                    pq.offer(new Pair(neighbor.node, time));
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(timeTaken[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, timeTaken[i]);
        }
        return minTime;
    }
}
