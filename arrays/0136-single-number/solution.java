class Solution {
    public int singleNumber(int[] nums) {
        /*Array Process
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int i = 0, num = 0;;
        while(i < nums.length) {
            if(nums[i] != nums[(i+1) % nums.length]) {
                num = nums[i];
                break;
            }
            else i += 2;
        }
        return num;*/
        int ans = 0;
        for(int num : nums) ans ^= num;
        return ans;
    }
}
