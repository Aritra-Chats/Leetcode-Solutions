class Solution {
    private String RLE(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length(), count = 1;
        for(int i = 1; i < length; i++) {
            if(s.charAt(i) == s.charAt(i - 1)) 
                count++;
            else {
                sb.append(count).append(s.charAt(i - 1));
                count  = 1;
            }
        }
        sb.append(count).append(s.charAt(length - 1));
        return sb.toString();
    }
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i <= n; i++)
            res = RLE(res);
        return res;
    }
}
