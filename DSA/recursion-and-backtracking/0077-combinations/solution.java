class Solution {
    private void buildCombinations(int idx, int n, int k, List<Integer> curr, List<List<Integer>> results) {
        if(curr.size() == k) {
            results.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i <= n; i++) {
            curr.add(i);
            buildCombinations(i+1, n, k, curr, results);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        buildCombinations(1, n, k, new ArrayList<>(), results);
        return results;
    }
}
