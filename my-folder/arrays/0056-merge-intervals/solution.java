class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int i = 0, j = 1;
        while(j < intervals.length) {
            if(intervals[i][1] >= intervals[j][0])
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            else 
                intervals[++i] = intervals[j];
            j++;
        }
        return Arrays.copyOfRange(intervals, 0, i+1);
    }
}
