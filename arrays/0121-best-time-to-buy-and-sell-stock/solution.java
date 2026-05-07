class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for(int sell = 1; sell < prices.length; sell++) {
            if(buy > prices[sell]) buy = prices[sell];
            profit = Math.max(profit, prices[sell] - buy);
        }
        return profit;
    }
}
