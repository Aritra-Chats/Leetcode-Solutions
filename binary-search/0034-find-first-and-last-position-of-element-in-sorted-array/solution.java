class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findFirst(nums, target), findLast(nums, target)};
    }

    public int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length-1, first = -1;
        while(l <= h) {
            int m = l + (h-l)/2;
            if (nums[m] == target) {
                if ((m == 0) || (nums[m-1] != target)) {
                    first = m;
                    break;
                } else
                    h = m-1;
            } 
            else if (nums[m] > target)
                h = m-1;
            else
                l = m+1;
        }
        return first;
    }

    public int findLast(int[] nums, int target) {
        if(nums.length == 1) return (nums[0] == target) ? 0 : -1;
        int l = 0, h = nums.length-1, last = -1;
        while(l <= h) {
            int m = l + (h-l)/2;
            if (nums[m] == target) {
                if ((m == nums.length-1) || (nums[m+1] != target)) {
                    last = m;
                    break;
                }
                else l = m+1;
            } 
            else if (nums[m] > target)
                h = m-1;
            else
                l = m+1;
        }
        return last;
    }
}
