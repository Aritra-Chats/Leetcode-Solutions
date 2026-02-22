class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 2 * nums.length; i++) {
            while(!s.isEmpty() && nums[s.peek()] < nums[i % nums.length])
                res[s.pop()] = nums[i % nums.length];
            if(i < nums.length)
                s.push(i % nums.length);
        }
        return res;
    }
}
