class Solution {
    public boolean isPossible(int[] piles, int h, int k) {
        int totalTime = 0;
        for(int bananas : piles) {
            totalTime += (bananas + k - 1) / k;
        }
        return totalTime <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int bananas : piles) {
            max = Math.max(max, bananas);
        }
        int l = 1, hi = max;
        while(l < hi) {
            int m = l + (hi-l)/2;
            if(isPossible(piles, h, m)) {
                hi = m;
            }
            else 
                l = m+1;
        }
        return l;
    }
}
