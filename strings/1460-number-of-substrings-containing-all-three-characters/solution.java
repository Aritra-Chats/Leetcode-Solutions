class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = new int[]{-1, -1, -1};
        int len = s.length(), count = 0;
        for(int i = 0; i < len; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) 
                count += Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])) + 1;
        }
        return count;
    }
}
