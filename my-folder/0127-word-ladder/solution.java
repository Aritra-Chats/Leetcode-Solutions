class Solution {
    private int bfs(String beginWord, String endWord, Map<String, List<String>> adjMap) {
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        queue.offer(beginWord);
        vis.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return level;
                for(String neighbor : adjMap.get(word)) {
                    if(!vis.contains(neighbor)) {
                        queue.offer(neighbor);
                        vis.add(neighbor);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public static Map<String, List<String>> buildAdjMap(List<String> wordList) {
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, List<String>> patternMap = new HashMap<>();
        int L = wordList.get(0).length();
        for (String word : wordList) {
            adjMap.put(word, new ArrayList<>());
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                for (String neighbor : patternMap.get(pattern)) {
                    if (!neighbor.equals(word)) {
                        adjMap.get(word).add(neighbor);
                    }
                }
            }
        }
        
        return adjMap;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() <= 0) return 0;
        if(beginWord.equals(endWord)) return 1;
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        Map<String, List<String>> adjMap = buildAdjMap(wordList);
        return bfs(beginWord, endWord, adjMap);
    }
}
