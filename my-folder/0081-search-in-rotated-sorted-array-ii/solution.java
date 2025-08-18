class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        while(l <= h) {
            int m = l + (h-l)/2;
            if(nums[m] == target) return true;
            if(nums[l] < nums[m]) {            //Left side is sorted
                if(target >= nums[l] && target < nums[m]) h = m-1;      //present in left side
                else l = m+1;                                           //Not present in left side
            } else if(nums[m] < nums[h]) {     //right side is sorted
                if(target > nums[m] && target <= nums[h]) l = m+1;      //present in right side
                else h = m-1;                                           //not present in left side
            }
            else {                             //l, m and h have same elements
                if(nums[l] == nums[m]) l++;
                if(nums[m] == nums[h]) h--;
            }
        }
        return false;
    }
}
