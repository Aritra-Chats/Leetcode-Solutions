class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] prev = new int[amount+1];
        final int INF = amount+1;
        Arrays.fill(prev, INF);
        prev[0] = 0;
        for(int i = 1; i <= len; i++) {
            int[] curr = prev;
            for(int val = 0; val <= amount; val++)
                curr[val] = (coins[i-1] <= val) ? Math.min(prev[val], curr[val - coins[i-1]] + 1) : prev[val];
            prev = curr;
        }
        return (prev[amount] == INF) ? -1 : prev[amount];
    }
}
