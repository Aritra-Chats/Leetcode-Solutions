class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length(), maxFreq = 0, left = 0, maxLen = 0;
        int[] freq = new int[26];
        for(int right = 0; right < len; right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
