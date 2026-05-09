class Solution {
    public int xorOperation(int n, int start) {
        int last = start, xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= last;
            last += 2;
        }
        return xor;
    }
}
