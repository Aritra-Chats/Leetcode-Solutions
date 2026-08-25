class Solution {
    public String removeDuplicateLetters(String s) {
        int  len = s.length();
        int[] last = new int[26];
        for(int i = 0; i < len; i++)
            last[s.charAt(i) - 'a'] = i;
        Deque<Character> st = new ArrayDeque<>();
        boolean[] included = new boolean[26];
        for(int i = 0; i <len; i++) {
            char ch = s.charAt(i);
            if(included[ch - 'a'])
                continue;
            while(!st.isEmpty() && st.peek() > ch && last[st.peek() - 'a'] > i)
                included[st.pop() - 'a'] = false;
            st.push(ch);
            included[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.insert(0, st.pop());
        return sb.toString();
    }
}
