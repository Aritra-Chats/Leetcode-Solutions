class Solution {
    private double power(double x, long n) {
        if(n == 0)
            return 1;
        double half = power(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }
    public double myPow(double x, int n) {
        if(x == 1 || n == 1)
            return x;
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
}
