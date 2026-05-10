class Solution {
    private int moveLeft(int[] numbers, int left, int right) {
        do{
            left++;
        } while(left < right && numbers[left] == numbers[left - 1]);
        return left;
    }
    private int moveRight(int[] numbers, int left, int right) {
        do{
            right--;
        } while(left < right && numbers[right] == numbers[right + 1]);
        return right;
    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int result = numbers[left] + numbers[right];
            if(result == target)
                return new int[]{left + 1, right + 1};
            else if(result < target)
                left = moveLeft(numbers, left, right);
            else
                right = moveRight(numbers, left, right);
        }
        return new int[]{-1, -1};
    }
}
