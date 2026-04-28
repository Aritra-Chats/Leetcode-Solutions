class Solution {
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (dist(a) - dist(b)));
        for(int[] point : points)
            pq.offer(point);
        int[][] result = new int[k][];
        int size = 0;
        while(size < k) {
            result[size] = pq.poll();
            size++;
        } 
        return result;
    }
}
