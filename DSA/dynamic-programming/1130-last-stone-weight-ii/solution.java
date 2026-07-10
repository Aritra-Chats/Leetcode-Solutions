class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones)
            sum += stone;
        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int stone : stones) {
            for(int s = target; s >= stone; s--) 
                dp[s] |= dp[s-stone];
        }
        int min = 0;
        for(int i = target; i >= 0; i--)
            if(dp[i] == true) {
                min = i;
                break;
            }
        return sum - 2 * min;
    }
}
