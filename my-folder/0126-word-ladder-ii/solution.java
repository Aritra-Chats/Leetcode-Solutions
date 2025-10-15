class Solution {
    private void dfs(String word, String beginWord, Map<String, List<String>> parents, List<String> path, List<List<String>> result) {
        if(word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            result.add(copy);
            return;
        }
        if(!parents.containsKey(word)) return;
        for(String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, result);
            path.remove(path.size()-1);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return new ArrayList<>(List.of(List.of(beginWord)));
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return result;
        if(!dict.contains(beginWord)) dict.add(beginWord);
        
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        queue.offer(beginWord);
        vis.add(beginWord);
        boolean found = false;

        while(!queue.isEmpty() && !found) {
            Set<String> thisLevel = new HashSet<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for(int j = 0; j < wordArray.length; j++) {
                    char original = wordArray[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == original) continue;
                        wordArray[j] = c;
                        String next = new String(wordArray);
                        if(dict.contains(next)) {
                            if(!vis.contains(next)) {
                                if(!thisLevel.contains(next)) {
                                    queue.offer(next);
                                    thisLevel.add(next);
                                }
                                parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            }
                            if(next.equals(endWord)) found = true;
                        }
                    }
                    wordArray[j] = original;
                }
            }
            vis.addAll(thisLevel);
        }
        if(found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parents, path, result);
        }
        return result;
    }
}
