class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray())
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        int maxFreq = 0;
        for(int freq : freqMap.values())
            maxFreq = Math.max(maxFreq, freq);
        if(maxFreq > (s.length() + 1) / 2) return "";
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(char ch : freqMap.keySet()) 
            pq.offer(new int[]{ch, freqMap.get(ch)});
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            int[] first = pq.poll(), second = pq.poll();
            sb.append((char)first[0]);
            sb.append((char)second[0]);
            if(--first[1] > 0) 
                pq.offer(first);
            if(--second[1] > 0) 
                pq.offer(second);
        }
        if(!pq.isEmpty())
            sb.append((char)pq.poll()[0]);
        return sb.toString();
    }
}
