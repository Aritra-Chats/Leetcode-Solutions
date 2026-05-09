class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, len = nums.length;
        for(int i = 1; i <= len; i++)
            xor ^= i;
        for(int i = 0; i < len; i++)
            xor ^= nums[i];
        return xor;
    }
}
