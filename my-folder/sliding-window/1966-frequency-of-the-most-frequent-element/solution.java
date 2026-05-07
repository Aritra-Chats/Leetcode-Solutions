import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int freq = 0;
        long total = 0;
        for(int right = left; right < nums.length; right++) {
            total += nums[right];
            while((long) nums[right] * (right-left+1) - total > k) {
                total -= nums[left];
                left++;
            }
            freq = Math.max(freq, right-left+1);
        }
        return freq;
    }
}
