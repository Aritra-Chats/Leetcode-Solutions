class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int i = 0, j = 1, count = 0;
        while(j < intervals.length) {
            if(intervals[i][1] > intervals[j][0])
                count++;
            else 
                i = j;
            j++;
        }
        return count;
    }
}
