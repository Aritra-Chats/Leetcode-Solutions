class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int len = points.length, arrows = 1, arrowPosition = points[0][1];
        for(int i = 1; i < len; i++) {
            if(points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }
        return arrows;
    }
}
