class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] jumps = new int[len];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        boolean reachedEnd = false;
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j <= i + nums[i]; j++) {
                if(j >= len)
                    break;
                jumps[j] = Math.min(jumps[j], jumps[i] + 1);
                if(j == len-1) {
                    reachedEnd = true;
                    break;
                }
            }
            if(reachedEnd)
                break;
        }
        return jumps[len-1];
    }
}
