class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length, totalSum = 0;
        for(int num : nums)
            totalSum += num;
        if(Math.abs(target) > totalSum || (target+totalSum) % 2 != 0)
            return 0;
        int actarget = (target + totalSum) / 2;
        int[] dp = new int[actarget+1];
        dp[0] = 1;
        for(int i = 1; i <= len; i++) {
            for(int val = actarget; val >= 0; val--) {
                dp[val] = (nums[i-1] <= val) ? dp[val] + dp[val-nums[i-1]] : dp[val];
            }
        }
        return dp[actarget];
    }
}
