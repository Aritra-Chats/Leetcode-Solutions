class Solution {
    public int maxDepth(String s) {
        int len = s.length(), currDepth = 0, maxDepth = 0;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') 
                currDepth++;
            else if(s.charAt(i) == ')')
                currDepth--;
            maxDepth = Math.max(maxDepth, currDepth);
        }
        return maxDepth;
    }
}
