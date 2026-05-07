class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums)
            total += num;
        if(total % 2 != 0) return false;
        int target = total / 2, len = nums.length;
        boolean[][] dp = new boolean[len+1][target+1];
        for(int i = 0; i <= len; i++)
            dp[i][0] = true;
        for(int i = 1; i <= len; i++) {
            for(int s = 1; s <= target; s++) {
                if(nums[i-1] <= s)
                    dp[i][s] = dp[i-1][s] || dp[i-1][s-nums[i-1]];
                else
                    dp[i][s] = dp[i-1][s];
            }
        }
        return dp[len][target];
    }
}
