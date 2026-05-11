class Solution {
    private int atMost(int[] nums, int k) {
        if(k < 0) return 0;
        int len = nums.length, left = 0, count = 0, subarrays = 0;
        for(int right = 0; right < len; right++) {
            if(nums[right] % 2 != 0)
                count++;
            while(count > k) {
                if(nums[left] % 2 != 0)
                    count--;
                left++;
            }
            subarrays += right - left + 1;
        }
        return subarrays;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}
