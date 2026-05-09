class Solution {
    private int countBits(int num) {
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1)
                count++;
            num >>= 1;
        }
        return count;
    }
    public int minimizeXor(int num1, int num2) {
        int count2 = countBits(num2), count1 = countBits(num1), closest = num1, idx = 0;
        while(count1 != count2) {
            if(count1 < count2) {
                if(((closest >> idx) & 1) == 0) {
                    closest |= (1 << idx);
                    count1++;
                }
                idx++;
            } else {
                if(((closest >> idx) & 1) == 1) {
                    closest &= ~(1 << idx);
                    count1--;
                }
                idx++;
            }
        }
        return closest;
    }
}
