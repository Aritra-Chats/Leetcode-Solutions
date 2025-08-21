class Solution {
    public int calculateDivisorSum(int[] nums, int value) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) 
            sum += (nums[i] + value - 1) / value;
        return sum; 
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, h = 0;
        for(int i = 0; i < nums.length; i++) 
            h = Math.max(h, nums[i]);
        int divisorSum = 0;
        while(l < h) {
            int m = l + (h-l)/2, sumOfM = calculateDivisorSum(nums, m);
            if(sumOfM <= threshold) 
                h = m;
            else
                l = m+1;
        }
        return l;
    }
}
