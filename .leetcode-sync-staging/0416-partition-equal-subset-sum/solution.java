class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums)
            total += num;
        if(total % 2 != 0)
            return false;
        int target = total / 2, len = nums.length;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        for(int i = 1; i <= len; i++) {
            boolean[] temp = new boolean[target+1];
            temp[0] = true;
            for(int s = 1; s <= target; s++)
                temp[s] = (nums[i-1] <= s) ? (prev[s] || prev[s-nums[i-1]]) : prev[s];
            prev = temp;
        }
        return prev[target];
    }
}
