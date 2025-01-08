int removeElement(int* nums, int numsSize, int val) {
    int i = 0;
    while (i < numsSize) {
        if (nums[i] == val) {
            if (i == numsSize - 1) {
                numsSize--;
                break;
            }
            for (int j = i; j < numsSize - 1; j++) {
                nums[j] = nums[j + 1];
            }
            numsSize--;
        } else {
            i++;
        }
    }
    return numsSize;
}
