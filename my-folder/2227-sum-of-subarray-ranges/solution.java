class Solution {
    public long subArrayRanges(int[] nums) {
        return getMaxSum(nums) - getMinSum(nums);
    }
    private long getMaxSum(int[] nums) {
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i <= nums.length; i++) {
            while(!s.isEmpty() && (i == nums.length || nums[s.peek()] < nums[i])) {
                int mid = s.pop(), left = s.isEmpty() ? -1 : s.peek(), right = i;
                res += (long)nums[mid] * (mid - left) * (right - mid);
            }
            s.push(i);
        }
        return res;
    }
    private long getMinSum(int[] nums) {
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i <= nums.length; i++) {
            while(!s.isEmpty() && (i == nums.length || nums[s.peek()] > nums[i])) {
                int mid = s.pop(), left = s.isEmpty() ? -1 : s.peek(), right = i;
                res += (long)nums[mid] * (mid - left) * (right - mid);
            }
            s.push(i);
        }
        return res;
    }
}
