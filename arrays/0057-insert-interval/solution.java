class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length, i = 0;
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        while(i < len && intervals[i][1] < newInterval[0])
            mergedIntervals.add(intervals[i++]);
        if(i == len) {
            mergedIntervals.add(newInterval);
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }
        int mergeStart = newInterval[0], mergeEnd = newInterval[1];
        while(i < len && intervals[i][0] <= newInterval[1]) {
            mergeStart = Math.min(intervals[i][0], mergeStart);
            mergeEnd = Math.max(intervals[i][1], mergeEnd);
            i++;
        }
        mergedIntervals.add(new int[]{mergeStart, mergeEnd});
        while(i < len)
            mergedIntervals.add(intervals[i++]);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
