class Solution {
    private int calc(int a, int b, int curr, int n) {
        if(curr == n)
            return a+b;
        return calc(a+b, a, curr + 1, n);
    }
    public int fib(int n) {
        if(n == 0) return 0;
        return calc(0, 1, 1, n);
    }
}
