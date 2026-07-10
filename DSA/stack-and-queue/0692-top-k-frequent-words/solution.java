class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words)
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> { 
                int freqCompare = freqMap.get(b)-freqMap.get(a);
                if(freqCompare == 0)
                    return a.compareTo(b);
                else
                    return freqCompare;
            });
        for(String word : freqMap.keySet())
            pq.offer(word);
        int count = 0;
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty() && count < k) {
            res.add(pq.poll());
            count++;
        }
        return res;
    }
}
