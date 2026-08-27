class Solution {
    public int trap(int[] height) {
        int size = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length-1;
        while(left < right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                size += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                size += rightMax - height[right];
                right--;
            }
        }
        return size;
    }
}
