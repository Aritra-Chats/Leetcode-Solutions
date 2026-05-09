class Solution {
    private void generateCombinations(int curr, int k, int n, List<Integer> iterator, List<List<Integer>> combinations) {
        if(k <= 0 || n <= 0) {
            if(k == 0 && n == 0)
                combinations.add(new ArrayList<>(iterator));
            return;
        }
        for(int i = curr; i < 10; i++) {
            if(i > n)
                break;
            iterator.add(i);
            generateCombinations(i + 1, k - 1, n - i, iterator, combinations);
            iterator.remove(iterator.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(1, k, n, new ArrayList<>(), combinations);
        return combinations;
    }
}
