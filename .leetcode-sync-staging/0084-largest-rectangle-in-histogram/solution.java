class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxSize = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            while(!s.isEmpty() && (i == heights.length || heights[s.peek()] > heights[i])) {
                int mid = s.pop(), left = s.isEmpty() ? -1 : s.peek(), right = i - 1;
                maxSize = Math.max(maxSize, heights[mid] * (right - left));
            }
            s.push(i);
        }
        return maxSize;
    }
}
