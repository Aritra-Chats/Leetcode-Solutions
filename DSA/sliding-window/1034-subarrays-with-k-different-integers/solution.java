class Solution {
    private int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int len = nums.length, left = 0, count = 0;
        for(int right = 0; right < len; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while(freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if(freqMap.get(nums[left]) == 0)
                    freqMap.remove(nums[left]);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}
