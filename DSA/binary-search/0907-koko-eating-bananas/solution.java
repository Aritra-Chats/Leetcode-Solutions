class Solution {
    private boolean canFinishBananasInTime(int mid, int[] piles, int h) {
        long time = 0;
        for(int pile : piles) 
            time += (pile +(long) mid - 1) / mid;
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int pile : piles) {
            if(pile > high)
                high = pile;
        }
        while(high - low > 0) {
            int mid = low + (high - low) / 2;
            if(canFinishBananasInTime(mid, piles, h)) 
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }
}
