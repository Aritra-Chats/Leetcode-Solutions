class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int maxLength = 1, length = 1, currentKey = 0;
        for(int num : set) {
            if(!set.contains(num-1)) {
                currentKey = num;
                length = 1;
                while (set.contains(currentKey+1)) {
                    length++;
                    currentKey++;
                }
                num = currentKey;
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}
