class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] map = new int[grid.length * grid.length];
        int missing = -1, repition = -1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(map[grid[i][j]-1] == 1) repition = grid[i][j];
                else map[grid[i][j]-1]++;
            }
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 0) {
                missing = i+1;
                break;
            }
        }
        return (new int[]{repition, missing});
    }
}
