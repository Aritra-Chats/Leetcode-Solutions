class Solution {
    private void swap(int[] nums, int i, int j) {
        if(i >= j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void generatePermutations(int idx, int[] nums, List<Integer> iterator, List<List<Integer>> permutations) {
        int len = nums.length;
        if(idx == len) {
            permutations.add(new ArrayList<>(iterator));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = idx; i < len; i++) {
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(nums, idx, i);
            iterator.add(nums[idx]);
            generatePermutations(idx + 1, nums, iterator, permutations);
            iterator.remove(iterator.size() - 1);
            swap(nums, idx, i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(0, nums, new ArrayList<>(), permutations);
        return permutations;
    }
}
