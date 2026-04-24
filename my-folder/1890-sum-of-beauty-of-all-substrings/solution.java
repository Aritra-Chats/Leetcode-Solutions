class Solution {
    public int beautySum(String s) {
        int len = s.length(), count = 0;
        for(int i = 0; i < len; i++) {
            int[] freq = new int[26];
            int max = 0;
            for (int j = i; j < len; j++) {
                int idx = s.charAt(j) - 'a'; 
                freq[idx]++;
                max = Math.max(max, freq[idx]);
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++) {
                    if(freq[k] > 0) {
                        min = Math.min(min, freq[k]);
                    }
                }
                count += max-min;
            }
        }
        return count;
    }
}
