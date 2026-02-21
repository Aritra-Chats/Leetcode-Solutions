class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int elem : nums2) {
            while(!s.isEmpty() && s.peek() < elem)
                map.put(s.pop(), elem);
            s.push(elem);
        }
        while(!s.isEmpty())
            map.put(s.pop(), -1);
        for(int i = 0; i < nums1.length; i++)
            res[i] = map.get(nums1[i]);
        return res;
    }
}
