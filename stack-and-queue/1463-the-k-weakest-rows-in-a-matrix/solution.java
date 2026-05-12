class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[] freq = new int[m];
        for(int i = 0; i < m; i++)
            for(int num : mat[i]) {
                if(num == 0)
                    break;
                freq[i]++;
            }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        for(int i = 0; i < m; i++)
            pq.offer(new int[]{freq[i], i});
        int count = 0;
        int[] res = new int[k];
        while(!pq.isEmpty() && count < k)
            res[count++] = pq.poll()[1];
        return res;
    }
}
