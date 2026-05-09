class Solution {
    public int singleNumber(int[] nums) {
        int missing = 0;
        for(int num : nums)
            missing ^= num;
        return missing;
    }
}
