class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] > 0)
                nums[index] = - nums[index];
            else
                duplicates.add(Math.abs(num));
        }
        return duplicates;
    }
}
