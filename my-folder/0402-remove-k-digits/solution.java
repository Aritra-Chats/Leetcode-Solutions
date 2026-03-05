class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Deque<Character> s = new ArrayDeque<>();
        for(char c : num.toCharArray()) {
            while(!s.isEmpty() && k > 0 && s.peekLast() > c) {
                k--;
                s.removeLast();
            }
            s.addLast(c);
        }
        while(k > 0){
            s.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.removeFirst());
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0')
            i++;
        String result = sb.substring(i);
        return result.length() > 0 ? result : "0";
    }
}
