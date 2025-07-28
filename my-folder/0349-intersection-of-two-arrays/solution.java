class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] map = new boolean[1001];
        for(int num : nums1) {
            map[num] = true;
        }
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for(int num : nums2) {
            if(map[num]) {
                temp[index++] = num;
                map[num] = false;
            }
        }
        return Arrays.copyOf(temp, index);
    }
}
