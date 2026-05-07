class Solution {
    public boolean canJump(int[] nums) {
        /*if(nums.length == 1 || nums[0] >= nums.length - 1) return true;
        int currPos = 0, maxPos = currPos + nums[currPos];
        while(maxPos < nums.length - 1) {
            int nextJumpDist = 0, nextPos = 0; 
            for(int i = currPos + 1; i <= maxPos; i++)
                if(i + nums[i] >= nextJumpDist) {
                    nextJumpDist = i + nums[i];
                    nextPos = i;
                }
            if(nextPos == currPos || maxPos == nextPos + nums[nextPos]) return false; 
            currPos = nextPos; 
            maxPos = currPos + nums[currPos];
        }
        return true;*/
        int n = nums.length;
        int remaining = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i] == 0 && remaining == 0)
                return false;
            remaining = Math.max(remaining - 1, nums[i] - 1);
        }
        return true;
    }
}
