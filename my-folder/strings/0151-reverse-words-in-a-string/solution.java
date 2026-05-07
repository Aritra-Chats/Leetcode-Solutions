class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int len = strs.length, idx = 0;
        for(int i = 0; i < len; i++) {
            if(strs[i].length() != 0)
                strs[idx++] = strs[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = idx - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if(i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
