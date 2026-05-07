class Solution {
    private int highestHistogram(int[] h) {
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i = 0; i <= h.length; i++) {
            int curr = (i == h.length) ? 0 : h[i];
            while(!s.isEmpty() && h[s.peek()] > curr) {
                int height = h[s.pop()], left = s.isEmpty() ? -1 : s.peek(), right = i - 1;
                max = Math.max(max, height * (right - left));
            }
            s.push(i);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int max = 0, row = matrix.length, col = matrix[0].length;
        int[] height = new int[col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            max = Math.max(max, highestHistogram(height));
        }
        return max;
    }
}
