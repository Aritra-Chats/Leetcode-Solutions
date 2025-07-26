class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(i < nums1.length-1 && nums1[i] == nums1[i+1]) continue;
            for(int j = 0; j < nums2.length; j++) {
                if(j < nums2.length-1 && nums2[j] == nums2[j+1]) continue;
                if(nums1[i] == nums2[j] && !intersection.contains(nums1[i])) intersection.add(nums1[i]);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
