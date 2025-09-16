class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i >= 0; i--){
            sb.append(strs[i]);
            if(i != 0 && strs[i] != "") sb.append(" ");
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }
        sb.setLength(i + 1);
        return sb.toString();
    }
}
