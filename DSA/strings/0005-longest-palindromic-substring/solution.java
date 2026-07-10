class Solution {
    private int expand(String s, int left, int right) {
        int length = s.length();
        while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int length = s.length();
        for(int i = 0; i < length; i++) {
            int len1 = expand(s, i, i), len2 = expand(s, i, i + 1), len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end  = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
