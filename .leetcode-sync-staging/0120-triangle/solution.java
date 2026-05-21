class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] last = new int[n];
        for(int i = 0; i < n; i++)
            last[i] = triangle.get(n - 1).get(i);
        for(int i = n - 2; i >= 0; i--) {
            int[] temp = new int[i+1];
            for(int j = i; j >= 0;j--)
                temp[j] = triangle.get(i).get(j) + Math.min(last[j], last[j+1]);
            last = Arrays.copyOf(temp, i + 1);
        }
        return last[0];
    }
}
