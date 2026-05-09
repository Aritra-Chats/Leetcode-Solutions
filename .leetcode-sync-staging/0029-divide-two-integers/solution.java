class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long remainder = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
        int quotient = 0;
        while(remainder >= dvs) {
            int curr = 0;
            while(remainder > (dvs << (curr + 1)))
                curr++;
            quotient += (1 << curr);
            remainder -= (dvs << curr);
        }
        return (dividend < 0 ^ divisor < 0) ? -quotient : quotient;
    }
}
