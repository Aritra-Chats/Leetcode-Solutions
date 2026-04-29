class Solution {
    private int lowerBound(int[] temp, int size, int target) {
        int low = 0, high = size;
        while(low < high) {
            int mid = (low + high) / 2;
            if(temp[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, size = 1;
        int[] temp = new int[len];
        temp[0] = nums[0];
        for(int i = 1; i < len; i++) {
            if(nums[i] > temp[size-1])
                temp[size++] = nums[i];
            else 
                temp[lowerBound(temp, size, nums[i])] = nums[i];
        }
        return size;
    }
}
