class Solution {
    private boolean feasible(int[] nums, int maxSum, int k) {
        int subArrays = 1, len = nums.length, sum = 0;
        for(int i = 0; i < len; i++) {
            if(sum + nums[i] <= maxSum) 
                sum += nums[i];
            else {
                subArrays++;
                sum = nums[i];
            }
            if(subArrays > k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;
        int low = 0, high = 0, ans = -1;
        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high) {
            int mid = (high + low) / 2;
            if(feasible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
