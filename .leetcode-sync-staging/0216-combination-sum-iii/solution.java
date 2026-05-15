class Solution {
    private void generateCombinations(int num, int count, int k, int sum, int n, List<Integer> iterator, List<List<Integer>> combinations) {
        if(count >= k || sum >= n || num > 9) {
            if(count == k && sum == n)
                combinations.add(new ArrayList<>(iterator));
            return;
        }
        iterator.add(num);
        generateCombinations(num + 1, count + 1, k, sum + num, n, iterator, combinations);
        iterator.remove(iterator.size() - 1);
        generateCombinations(num + 1, count, k, sum, n, iterator, combinations);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(1, 0, k, 0, n, new ArrayList<>(), combinations);
        return combinations;
    }
}
