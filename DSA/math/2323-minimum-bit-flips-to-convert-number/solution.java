class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0, val = start;
        while(val != goal) {
            int xor = val ^ goal, diff = xor & -xor;
            val ^= diff;
            count++;
        }
        return count;
    }
}
