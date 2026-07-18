class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums, (a, b) -> (
                                (a.length() != b.length()) ? a.length() - b.length() : a.compareTo(b)
                            ));
        return nums[len-k];
    }
}
