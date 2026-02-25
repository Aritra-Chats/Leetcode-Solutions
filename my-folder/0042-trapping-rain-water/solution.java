class Solution {
    public int trap(int[] height) {
        int size = 0, leftMax = 0, rightMax = 0, l = 0, r = height.length-1;
        while(l < r) {
            if(height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                size += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                size += rightMax - height[r];
                r--;
            }
        }
        return size;
    }
}
