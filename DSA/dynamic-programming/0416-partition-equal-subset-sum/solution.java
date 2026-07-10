class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums)
            total += num;
        if(total % 2 != 0) return false;
        int target = total / 2, len = nums.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for(int j = target; j > 0; j--) {
                if(nums[i-1] <= j)
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                else
                    dp[j] = dp[j];
            }
        }
        return dp[target];
    }
}
