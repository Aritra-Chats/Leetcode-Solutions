class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
        int prev = nums[2] + nums[0], prev1 = nums[1], prev2 = nums[0];
        for(int i = 3; i < len; i++) {
            int curr = nums[i] + Math.max(prev1, prev2);
            prev2 = prev1;
            prev1 = prev;
            prev = curr;
        }
        return Math.max(prev, prev1);
    }
}
