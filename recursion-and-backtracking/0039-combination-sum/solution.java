class Solution {
    private void findCombinations(int idx, int[] candidates, int target, List<Integer> iterator, List<List<Integer>> combinations) {
        if(idx == candidates.length || target <= 0) {
            if(target == 0)
                combinations.add(new ArrayList<>(iterator));
            return;
        }
        iterator.add(candidates[idx]);
        findCombinations(idx, candidates, target - candidates[idx], iterator, combinations);
        iterator.remove(iterator.size() - 1);
        findCombinations(idx + 1, candidates, target, iterator, combinations);
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<Integer>(), combinations);
        return combinations;
    }
}
