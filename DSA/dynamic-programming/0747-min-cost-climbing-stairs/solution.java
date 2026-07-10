class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 1)
            return cost[0];
        if(len == 2)
            return Math.min(cost[0], cost[1]);
        int prev = cost[1], prev1 = cost[0];
        for(int i = 2; i < len; i++) {
            int curr = cost[i] + Math.min(prev, prev1);
            prev1 = prev;
            prev = curr;
        }
        return Math.min(prev, prev1);
    }
}
