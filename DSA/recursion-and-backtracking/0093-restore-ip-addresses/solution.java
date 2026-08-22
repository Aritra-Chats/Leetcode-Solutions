class Solution {
    private void buildIPs(String s, int idx, int parts, StringBuilder IP, List<String> result) {
        if(parts == 4) {
            if(idx == s.length())
                result.add(IP.substring(0, IP.length()-1));
            return;
        }
        int length = s.length();
        for(int len = 1; len <= 3 && (idx + len) <= length; len++) {
            String part = s.substring(idx, idx+len);
            if((part.length() > 1 && part.charAt(0) == '0') || (Integer.parseInt(part) > 255))
                break;
            int oldLength = IP.length();
            IP.append(part).append('.');
            buildIPs(s, idx+len, parts+1, IP, result);
            IP.setLength(oldLength);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        buildIPs(s, 0, 0, new StringBuilder(), result);
        return result;
    }
}
