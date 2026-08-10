class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = len-1;
            while(right-left > 0) {
                int sum =nums[i]+ nums[left]+nums[right];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[left++], nums[right--]));
                    while(right-left > 0  && nums[left] == nums[left-1])
                        left++;
                    while(right-left > 0 && nums[right] == nums[right+1])
                        right--;
                }
                else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
