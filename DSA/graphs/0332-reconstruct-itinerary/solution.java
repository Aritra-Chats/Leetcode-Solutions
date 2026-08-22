class Solution {
    private void DFS(String src, Map<String, PriorityQueue<String>> adjMap, List<String> itinerary) {
        PriorityQueue<String> pq = adjMap.get(src);
        while(pq != null && !pq.isEmpty()) {
            String dst = pq.poll();
            DFS(dst, adjMap, itinerary);
        }
        itinerary.add(0, src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for(List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adjMap.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }
        List<String> itinerary = new ArrayList<>();
        DFS("JFK", adjMap, itinerary);
        return itinerary;
    }
}
