class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, len = nums.length, count = 0, zeroCount = 0;
        for(int j = 0; j < len; j++) {
            if(nums[j] == 0)
                zeroCount++;
            while(zeroCount > k) {
                if(nums[i] == 0)
                    zeroCount--;
                i++;
            } 
            count = Math.max(count, j - i + 1);
        }
        return count;
    }
}
