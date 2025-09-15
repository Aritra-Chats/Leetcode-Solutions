class Solution {
    public int minStartValue(int[] nums) {
        int minValue = 1, sum = 0, actualSum = 0;
        for(int i = 0;i < nums.length; i++) {
            actualSum += nums[i];
            sum += nums[i];
            if(sum <= 0) {
                minValue += (minValue == 1) ? Math.abs(sum) : Math.abs(sum)+1;
                sum = minValue + actualSum;
                if(minValue == 1) sum -= 1;
            }
        }
        return minValue;
    }
}
