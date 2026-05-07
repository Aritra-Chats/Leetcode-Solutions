class Solution {
    public int missingNumber(int[] nums) {
        int target = 0, cal = 0;
        for(int i = 0; i <= nums.length; i++) target = target^i;
        for(int num : nums) cal = cal^num;
        return target^cal;
    }
}
