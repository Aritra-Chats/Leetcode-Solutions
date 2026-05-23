class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length, totalSum = 0;
        for(int num : nums)
            totalSum += num;
        if(Math.abs(target) > totalSum || (target + totalSum) % 2 != 0)
            return 0;
        int actarget = (target + totalSum) / 2;
        int[] prev = new int[actarget+1];
        prev[0] = 1;
        for(int i = 1; i <= len; i++) {
            int[] temp = new int[actarget+1];
            for(int val = 0; val <= actarget; val++)
                temp[val] = (nums[i-1] <= val) ? prev[val] + prev[val-nums[i-1]] : prev[val];
            prev = temp; 
        }
        return prev[actarget];
    }
}
