class Solution {
    private void generateSubsets(int idx, int[] nums, List<Integer> iterator, List<List<Integer>> subsets) {
        int len = nums.length;
        if(idx <= len) {
            subsets.add(new ArrayList<>(iterator));
            if(idx == len)
                return;
        }
        for(int i = idx; i < len; i++) {
            if(i > idx && nums[i] == nums[i - 1])
                continue;
            iterator.add(nums[i]);
            generateSubsets(i + 1, nums, iterator, subsets);
            iterator.remove(iterator.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }
}
