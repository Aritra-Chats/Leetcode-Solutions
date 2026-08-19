class Solution {
    private boolean isShippable(int mid, int[] weights, int days) {
        int count = 1, totalWeight = 0;
        for(int weight : weights) {
            if(totalWeight + weight > mid) {
                count++;
                totalWeight = 0;
            }
            totalWeight += weight;
        }
        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while(high - low > 0) {
            int mid = low + (high - low) / 2;
            if(isShippable(mid, weights, days))
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}
