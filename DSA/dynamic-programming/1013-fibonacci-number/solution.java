class Solution {
    /*
    private int calcFib(int n, int[] dp) {
        if(dp[n] == -1)
            dp[n] = calcFib(n - 1, dp) + calcFib(n - 2, dp);
        return dp[n];
    }
    */
    public int fib(int n) {
        // Space Optimized 
        if(n <= 1)
            return n;
        int prev = 1, prev1 = 0;
        for(int i = 2; i <= n; i++) {
            int curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return prev;

        /* Tabulation
        if(n <= 1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) 
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
        */

        /* Memoization
        if(n <= 1) 
            return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return calcFib(n, dp);
        */

        /* Recursion
        if(n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
        */
    }
}
