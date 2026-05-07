class Solution {
    private int skipWhitespace(String s, int len, int i) {
        if(i >= len || s.charAt(i) != ' ')
            return i;
        return skipWhitespace(s, len, i + 1);
    }
    private long[] digitConversion(String s, int len, int i, boolean isNegative) {
        if(i >= len || !Character.isDigit(s.charAt(i)))
            return new long[]{0, 1};
        long[] next = digitConversion(s, len, i + 1, isNegative);
        int digit = s.charAt(i) - '0';
        long suffix = next[0], multiplier = next[1], limit = isNegative ? -(long)Integer.MIN_VALUE : Integer.MAX_VALUE;
        if(digit > (limit - suffix) / multiplier)
            return new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
        long curr = digit * multiplier + suffix;
        if(multiplier > limit / 10)
            multiplier = Long.MAX_VALUE;
        else
            multiplier *= 10;
        return new long[]{curr, multiplier};
    }
    public int myAtoi(String s) {
        int len = s.length(), i = skipWhitespace(s, len, 0);
        if(i >= len) return 0;
        boolean isNegative = false;
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
        }
        long[] res = digitConversion(s, len, i, isNegative);
        if(res[0] == Long.MAX_VALUE) 
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        long ans = isNegative ? -res[0] : res[0];
        if(ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)ans;
    }
}
