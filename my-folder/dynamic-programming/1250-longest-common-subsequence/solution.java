class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chArr1 = text1.toCharArray(), chArr2 = text2.toCharArray();
        int len1 = chArr1.length, len2 = chArr2.length;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(chArr1[i-1] == chArr2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
}
