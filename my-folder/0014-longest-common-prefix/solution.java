class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length, strLen = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strLen; i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < len; j++) 
                if(i >= strs[j].length() || strs[j].charAt(i) != ch) return sb.toString();
            sb.append(ch);
        }
        return sb.toString();
    }
}
