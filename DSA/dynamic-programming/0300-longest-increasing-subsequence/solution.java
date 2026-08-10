class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len+1][len+1];
        for(int i = len-1; i >= 0; i--) {
            for(int p = i-1; p >= -1; p--) {
                if(p == -1 || nums[i] > nums[p]) 
                    dp[i][p+1] = Math.max(dp[i+1][p+1], 1 + dp[i+1][i+1]);
                else
                    dp[i][p+1] = dp[i+1][p+1];
            }
        }
        return dp[0][0];
    }
}
