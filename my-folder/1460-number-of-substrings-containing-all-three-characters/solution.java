class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int len = s.length(), i = 0, j = 0, count = 0;
        while(j < len) {
            char ch = s.charAt(j);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            while(freqMap.size() == 3) {
                count += len - j;
                char rem = s.charAt(i);
                freqMap.put(rem, freqMap.get(rem) - 1);
                if(freqMap.get(rem) == 0) 
                    freqMap.remove(rem);
                i++;
            }
            j++;
        }
        return count;
    }
}
