class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
        int[] res = new int[k]; 
        int count = 0;
        while(!pq.isEmpty() && count < k) {
            res[count++] = pq.poll()[0];
        }
        return res;
    }
}
