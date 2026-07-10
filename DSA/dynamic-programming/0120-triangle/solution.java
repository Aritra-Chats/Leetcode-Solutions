class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        for(int i = 0; i < n; i++)
            prev[i] = triangle.get(n-1).get(i);
        for(int i = n - 2; i >= 0; i--) {
            int[] temp = new int[i+1];
            for(int j = i; j >= 0; j--) 
                temp[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j+1]);
            prev = temp;
        }
        return prev[0];
    }
}
