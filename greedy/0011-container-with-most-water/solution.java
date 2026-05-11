class Solution {
    public int maxArea(int[] height) {
        int len = height.length, left = 0, right = len - 1, maxArea = 0;
        while(left < right) {
            int width = right - left, currArea = width * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
