class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        int[] freqP = new int[26], freqComp = new int[26];
        for(char ch : p.toCharArray()) 
            freqP[ch - 'a']++;
        int len = s.length(), k = p.length();
        for(int i = 0; i < len; i++) {
            freqComp[s.charAt(i) - 'a']++;
            if(i >= k) 
                freqComp[s.charAt(i - k) - 'a']--;
            if(Arrays.equals(freqP, freqComp))
                anagrams.add(i - k + 1);
        }
        return anagrams;
    }
}
