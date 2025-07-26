class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, m);
        int index = 0, i = 0, j = 0; 
        while(i < m && j < n) {
            if(copy[i] <= nums2[j]) {
                if(copy[i] == nums2[j]) nums1[index++] = nums2[j++];
                nums1[index++] = copy[i++];
            }
            else nums1[index++] = nums2[j++];
        }
        while(i < m) nums1[index++] = copy[i++];
        while(j < n) nums1[index++] = nums2[j++];
    }
}
