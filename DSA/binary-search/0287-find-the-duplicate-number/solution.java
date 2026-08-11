class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length, hare = nums[0], tortoise = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(hare != tortoise);
        tortoise = nums[0];
        while(hare != tortoise) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}
