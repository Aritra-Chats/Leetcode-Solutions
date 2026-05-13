class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int total = profits.length;
        int[][] projects = new int[total][];
        for(int i = 0; i < total; i++)
            projects[i] = new int[]{capital[i], profits[i]};
        Arrays.sort(projects, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int completed = 0; completed < k; completed++) {
            while(idx < total && projects[idx][0] <= w)
                pq.offer(projects[idx++][1]);
            if(pq.isEmpty())
                break;
            w += pq.poll();
        }
        return w;
    }
}
