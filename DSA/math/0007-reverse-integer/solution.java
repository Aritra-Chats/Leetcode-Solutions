class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        int rev = 0;
        while(temp > 0) {
            try {
                rev = Math.addExact(Math.multiplyExact(rev, 10), temp % 10);
                temp /= 10;
            } catch (ArithmeticException e) {
                return 0;
            }
        }
        if(x < 0) rev *= -1;
        return rev;
        }
}
