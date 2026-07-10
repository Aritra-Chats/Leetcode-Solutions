class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        int[] map = new int[1001];
        for(int num : nums1) {
            map[num]++;
        }
        int[] temp = new int[nums1.length];
        int index = 0;
        for(int num : nums2) {
            if(map[num] != 0) {
                temp[index++] = num;
                map[num]--;
            }
        }
        return Arrays.copyOf(temp, index);
    }
}
