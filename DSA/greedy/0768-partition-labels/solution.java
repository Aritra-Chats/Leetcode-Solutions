class Solution {
    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        /*
        int[] freqMap = new int[26];
        for(char ch : s.toCharArray()) 
            freqMap[ch-'a']++;
        int start = 0, end = 0;
        Set<Character> seen = new HashSet<>();
        seen.add(s.charAt(0));
        List<Integer> result = new ArrayList<>();
        while(end < len) {
            while(end < len && !seen.isEmpty()) {
                char ch = s.charAt(end);
                if(!seen.contains(ch))
                    seen.add(ch);
                freqMap[ch  - 'a']--;
                if(freqMap[ch - 'a'] == 0)
                    seen.remove(ch);
                end++;
            }
            result.add(end - start);
            start = end;
            if(start < len)
                seen.add(s.charAt(start));
        }
        return result;
        */

        int[] last = new int[26];
        for(int i = 0; i < len; i++)
            last[s.charAt(i) - 'a'] = i;
        int start = 0, end = 0;
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end) {
                results.add(end - start + 1);
                start = end + 1;
            }
        }
        return results;
    }
}
