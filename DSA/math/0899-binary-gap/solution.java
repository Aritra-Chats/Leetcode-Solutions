class Solution {
    public int binaryGap(int n) {
        int len = 0, prev = -1,count = 0;
        while(n > 0) {
            int lsb = n & -n;
            count++;
            if(lsb == 1) {
                if(prev != -1)
                    len = Math.max(len, count - prev);
                prev = count;
            }
            n >>= 1;
        }
        return len;
    }
}
