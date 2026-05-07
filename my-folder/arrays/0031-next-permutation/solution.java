class Solution {

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int checkIndex = nums.length-1;
        boolean isDescending = false;
        while(nums[checkIndex] <= nums[--checkIndex]) {
            if(checkIndex == 0) {
                isDescending = true;
                break;
            }
            continue;
        }
        if(isDescending) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int swapIndex = nums.length-1;
        while((nums[swapIndex] <= nums[checkIndex]) && nums[swapIndex] <= nums[--swapIndex]) continue;
        int temp = nums[checkIndex];
        nums[checkIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
        reverse(nums, checkIndex+1, nums.length-1);
    }
}
