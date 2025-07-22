import java.util.*;

class Solution {
    public boolean check(int[] nums) {
        /*if(nums[0] == nums[nums.length-1]) nums = Arrays.stream(nums).distinct().toArray();
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[index] > nums[i]) index = i;
        }
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int rotation = nums.length - index;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != sorted[(i + rotation) % nums.length]) return false; 
        }
        return true;*/
        int count=0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[(i+1) % nums.length]) {
                if(++count > 1) return false;
            }
        }
        return true;
    }
}
