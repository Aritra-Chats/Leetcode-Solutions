class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>(), freqT = new HashMap<>();
        for(char ch : t.toCharArray())
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        int len = s.length(), have = 0, required = freqT.size(), left = 0,minLen = Integer.MAX_VALUE, start = 0;
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
                char lch = s.charAt(left);
                freqS.put(lch, freqS.get(lch) - 1);
                if(freqT.containsKey(lch) && freqS.get(lch) < freqT.get(lch))
                    have--;
                left++;
            }
        } 
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
