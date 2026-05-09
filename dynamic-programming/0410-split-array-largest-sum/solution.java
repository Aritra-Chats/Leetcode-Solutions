class Solution {
    private boolean feasible(int[] nums, int mid, int k) {
        int subArrays = 1, sum = 0;
        for(int num : nums) {
            if(sum + num > mid) {
                subArrays++;
                sum = num;
            } else
                sum += num;
            if(subArrays > k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return 0;
        int low = 0, high = 0, ans = -1;
        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high) {
            int mid = (low + high) / 2;
            if(feasible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
