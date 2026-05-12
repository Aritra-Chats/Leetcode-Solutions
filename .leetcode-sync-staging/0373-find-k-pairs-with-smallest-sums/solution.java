class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]+a[1]) - (b[0]+b[1]));
        for(int i = 0; i < Math.min(nums1.length, k); i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int num1 = curr[0], num2 = curr[1], idx2 = curr[2];
            res.add(Arrays.asList(num1, num2));
            if(idx2 + 1 < nums2.length) {
                pq.offer(new int[]{num1, nums2[idx2 + 1], idx2 + 1});
            }
        }
        return res;
    }
}
