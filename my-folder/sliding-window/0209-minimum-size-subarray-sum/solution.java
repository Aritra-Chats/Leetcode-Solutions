class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE, left = 0, sum = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                length = Math.min(length, (right - left + 1));
                sum -= nums[left++];
            }
        }
        return (length == Integer.MAX_VALUE) ? 0 : length;
    }
}
