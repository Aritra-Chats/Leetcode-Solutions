class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while(i >= 0) {
            int val = num.charAt(i) - '0';
            if(val % 2 != 0)
                break;
            i--;
        }
        return num.substring(0, i + 1);
    }
}
