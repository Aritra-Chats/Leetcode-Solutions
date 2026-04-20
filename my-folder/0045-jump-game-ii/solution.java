class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;  
        int currPos = 0, jumps = 1, maxPos = currPos + nums[currPos];
        while(maxPos < nums.length - 1) {
            int nextPos = 0, nextJumpDist = 0;
            for(int  i = currPos + 1; i <= maxPos; i++) {
                if(i + nums[i] > nextJumpDist) {
                    nextJumpDist = i + nums[i];
                    nextPos = i;
                }
            }
            currPos = nextPos;
            maxPos = currPos + nums[currPos];
            jumps++;
        }
        return jumps;
    }
}
