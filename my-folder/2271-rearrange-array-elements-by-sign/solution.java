class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posCount = 0, negCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result[posCount * 2] = nums[i];
                posCount++;
            } else {
                result[(negCount * 2) + 1] = nums[i];
                negCount++;
            }
        }
        return result;
    }
}
