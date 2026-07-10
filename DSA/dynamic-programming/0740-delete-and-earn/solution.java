class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) 
            max = Math.max(max, num);
        int[] numLine = new int[max + 1];
        for(int num : nums)
            numLine[num] += num;
        int prev = 0, prev1 = 0;
        for(int num : numLine) {
            int curr = Math.max(prev, prev1 + num);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}
