class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        int sum = 0, i = 2, first = 0, second = 1;
        do {
            sum = first + second;
            first = second;
            second = sum;
        } while(++i <= n);
        return sum;
    }
}
