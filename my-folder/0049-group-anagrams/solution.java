class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        
        // Frequency Grouping
        /*for(String str : strs) {
            int[] freq = new int[26];
            for(char ch : str.toCharArray()) 
                freq[ch - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int num : freq)
                sb.append('#').append(num);
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        } */

        // Sorted Grouping
        for(String str : strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
