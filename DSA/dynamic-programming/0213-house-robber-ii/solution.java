class Solution {
    private int rob(int[] nums, int start, int end) {
        int len = nums.length, prev1 = 0, prev2 = 0;
        for(int i = start; i < end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 1, nums.length), rob(nums, 0, nums.length - 1));
    }
}
