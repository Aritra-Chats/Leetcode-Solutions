class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int prev = 2, prev1 = 1;
        for(int i = 3; i <= n; i++) {
            int curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}
