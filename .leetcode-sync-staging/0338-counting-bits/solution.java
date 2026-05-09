class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int bitIdx = 0;
        while(1 << bitIdx <= n) {
            bits[(1 << (bitIdx++))] = 1;
        } 
        for(int i = 3; i <= n; i++) {
            if(bits[i] != 0)
                continue;
            if(i % 2 == 0)
                bits[i] = bits[i / 2];
            else
                bits[i] = bits[i-1] + 1;
        }
        return bits;
    }
}
