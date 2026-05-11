class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> freqT = new HashMap<>(), freqS = new HashMap<>();
        for(char ch : t.toCharArray()) 
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        int left = 0, have = 0, required = freqT.size(), len = s.length(), start = 0, minLen = Integer.MAX_VALUE;
        for(int right = 0; right < len; right++) {
            char ch = s.charAt(right);
            freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);
            if(freqT.containsKey(ch) && freqS.get(ch).intValue() == freqT.get(ch).intValue())
                have++;
            while(have == required) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freqS.put(leftChar, freqS.get(leftChar) - 1);
                if(freqT.containsKey(leftChar) && freqS.get(leftChar) < freqT.get(leftChar))
                    have--;
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
