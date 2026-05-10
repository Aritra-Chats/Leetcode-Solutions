class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int len = nums.length, i = 0;
        Set<Integer> set = new HashSet<>();
        for(int j = 0; j < len; j++) {
            while(i < len && set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(nums[j]);
            sum += nums[j];
            if(j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        } 
        return maxSum;
    }
}
