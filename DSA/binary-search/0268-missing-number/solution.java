class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        long expectedSum = (len * (len+1)) / 2, actualSum = 0;
        for(int num : nums)
            actualSum += num;
        return (int)(expectedSum- actualSum);
    }
}
