class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0]. length;
        int[] last = new int[n], temp = new int[n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1)
                    temp[j] = Math.max(0, -dungeon[i][j]);
                else
                    temp[j] = Math.max(0, 
                    Math.min((j == n - 1) ? Integer.MAX_VALUE : temp[j+1], (i == m - 1) ? Integer.MAX_VALUE : last[j]) - dungeon[i][j]);
            }
            last = Arrays.copyOf(temp, n);
        }
        return last[0] + 1;
    }
}
