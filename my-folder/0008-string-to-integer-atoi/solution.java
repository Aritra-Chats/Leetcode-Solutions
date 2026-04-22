class Solution {
    public int myAtoi(String s) {
        int res = 0, len = s.length(), i = 0;
        boolean isNegative = false;
        while(i < len && s.charAt(i) == ' ') i++;
        if(i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }
        while(i < len && Character.isDigit(s.charAt(i))) {
            int val = s.charAt(i) - '0';
            if(res > (Integer.MAX_VALUE - val) / 10) 
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + val;
            i++;
        }
        return (int)(isNegative ? -1 * res : res);
    }
}
