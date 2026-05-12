class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, len = cardPoints.length, rightSum = 0;
        for(int i = 0; i < k; i++)
            leftSum += cardPoints[i];
        int maxSum = leftSum;
        for(int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[len - (k - i)];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}
