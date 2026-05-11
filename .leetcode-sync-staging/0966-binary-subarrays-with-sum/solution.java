class Solution {
    private int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;
        int len = nums.length, sum = 0, left = 0, count = 0;
        for(int right = 0; right < len; right++) {
            sum += nums[right];
            while((sum > goal))
                sum -= nums[left++];
            count += right - left + 1;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}
