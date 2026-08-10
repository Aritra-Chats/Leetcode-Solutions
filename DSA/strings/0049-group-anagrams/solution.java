class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> anagramMap = new HashMap<>();
       for(String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
       }
       return new ArrayList<>(anagramMap.values());
    }
}
