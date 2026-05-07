class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int i=0;i<bloomDay.length;i++) {
            if (bloomDay[i] <= day) {
                if (++flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
                if (bloomDay.length - i < (m - bouquets) * k)
                        break;
            }

            if(bouquets==m) break;
        }
        return bouquets == m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long) m * k) return -1;
        int h = 0, l = Integer.MAX_VALUE;
        for(int day : bloomDay) {
            h = Math.max(h, day);
            l = Math.min(l, day);
        }
        while(l < h) {
            int mid = l + (h-l)/2;
            if(isPossible(bloomDay, m, k, mid))
                h = mid;
            else {
                l = mid+1;
            }
        }
        return l;
    }
}
