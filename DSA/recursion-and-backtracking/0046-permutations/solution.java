class Solution {
    private void swap(int[] arr, int i, int j) {
        if(i >= j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void generatePermutations(int idx, int[] nums, List<Integer> iterator, List<List<Integer>> permutations) {
        int len = nums.length;
        if(idx == len) {
            permutations.add(new ArrayList<>(iterator));
            return;
        }
        for(int i = idx; i < len; i++) {
            swap(nums, idx, i);
            iterator.add(nums[idx]);
            generatePermutations(idx + 1, nums, iterator, permutations);
            iterator.remove(iterator.size() - 1);
            swap(nums, idx, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(0, nums, new ArrayList<>(), permutations);
        return permutations;
    }
}
