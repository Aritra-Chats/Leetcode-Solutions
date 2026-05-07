class Solution {
    public int max(int[] weights) {
        int max = weights[0];
        for(int i = 1; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }
        return max;
    }
    public int sum(int[] weights) {
        int sum = 0;
        for(int weight : weights) 
            sum += weight;
        return sum;
    }
    public boolean isEnoughCapacity(int[] weights, int days, int capacity) {
        int remainingDays = days, sum = 0;
        for(int i = 0; i < weights.length; i++) {
            if(sum + weights[i] > capacity) {
                remainingDays--;
                sum = weights[i];
            } else
                sum += weights[i];
        }
        remainingDays--;
        return (remainingDays >= 0);
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights), high = sum(weights);
        while(low < high) {
            int mid = low+(high-low)/2;
            if(isEnoughCapacity(weights, days, mid))
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }
}
