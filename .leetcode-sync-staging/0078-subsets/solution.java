class Solution {
    private void generateSubSets(int idx, int[] nums, ArrayList<Integer> iterator, List<List<Integer>> subset) {
        if(idx == nums.length) {
            subset.add(new ArrayList<>(iterator));
            return;
        }
        iterator.add(nums[idx]);
        generateSubSets(idx + 1, nums, iterator, subset);
        iterator.remove(iterator.size() - 1);
        generateSubSets(idx + 1, nums, iterator, subset);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        generateSubSets(0, nums, new ArrayList<Integer>(), subset);
        return subset;
    }
}
