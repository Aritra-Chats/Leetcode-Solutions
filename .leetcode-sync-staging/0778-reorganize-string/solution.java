class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'a']);
        }
        if(maxFreq > (s.length() + 1) / 2) 
            return "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < 26; i++)
            if(freq[i] != 0) 
                pq.offer(new int[]{i, freq[i]});
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            int[] first = pq.poll(), second = pq.poll();
            sb.append((char)('a' + first[0]));
            sb.append((char)('a' + second[0]));
            if(--first[1] > 0) 
                pq.offer(first);
            if(--second[1] > 0) 
                pq.offer(second);
        }
        if(!pq.isEmpty())
            sb.append((char)('a' + pq.poll()[0]));
        return sb.toString();
    }
}
