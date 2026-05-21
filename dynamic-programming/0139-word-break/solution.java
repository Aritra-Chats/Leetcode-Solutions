class Solution {
    private boolean isBreakable(int idx, String s, Set<String> dict, Boolean[] dp) {
        if(idx == s.length())
            return true;
        if(dp[idx] != null)
            return dp[idx];
        int len = s.length();
        for(int i = idx + 1; i <= len; i++) {
            if(dict.contains(s.substring(idx, i)) && isBreakable(i, s, dict, dp))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return isBreakable(0, s, dict, new Boolean[s.length()]);
    }
}
