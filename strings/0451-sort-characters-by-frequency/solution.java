class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; i++) 
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            char c = e.getKey();
            int freq = e.getValue();
            while(freq > 0) {
                sb.append(c);
                freq--;
            } 
        }
        return sb.toString();
    }
}
