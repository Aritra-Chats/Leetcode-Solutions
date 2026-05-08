class Solution {
    private void findCombinations(int idx, int[] candidates, int target, List<Integer> iterator, List<List<Integer>> combinations) {
        if(target == 0) {
            combinations.add(new ArrayList<>(iterator));
            return;
        }
        int len = candidates.length;
        for(int i = idx; i < len; i++) {
            if(i > idx && candidates[i] == candidates[i - 1])
                continue;
            if(candidates[i] > target)
                break;
            iterator.add(candidates[i]);
            findCombinations(i + 1, candidates, target - candidates[i], iterator, combinations);
            iterator.remove(iterator.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), combinations);
        return combinations;
    }
}
