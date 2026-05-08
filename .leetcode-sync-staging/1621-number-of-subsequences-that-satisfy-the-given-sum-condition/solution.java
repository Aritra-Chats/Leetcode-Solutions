class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = 1_000_000_007, len = nums.length, l = 0, r = len - 1, count = 0;
        int[] power = new int[len];
        power[0] = 1;
        for(int i = 1; i < len; i++) 
            power[i] = (power[i-1] * 2) % MOD;
        while(l <= r) {
            if(nums[l] + nums[r] <= target) {
                count  = (count + power[r - l]) % MOD;
                l++;
            } else
                r--;
        }
        return count;
    }
}
