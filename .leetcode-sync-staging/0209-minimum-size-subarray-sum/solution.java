class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length, sum = 0, left = 0, minLen = Integer.MAX_VALUE;
        for(int right = 0; right < len; right++) {
            sum += nums[right];
            while(sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
