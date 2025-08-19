class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int  l = 1, h = x/2, ans = 0;
        while(l <= h) {
            int m = l + (h-l)/2;
            long sqr = (long) m * m;
            if(sqr == x) return m;
            if(sqr < x) {
                ans = m;
                l = m+1;
            }
            else
                h = m-1;
        }
        return ans;
    }
}
