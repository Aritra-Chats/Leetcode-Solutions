class Solution {
    private void genValidParenthesis(int open, int close, int n, StringBuilder sb, List<String> parenthesis) {
        if(open == n && close == n) {
            parenthesis.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            genValidParenthesis(open + 1, close, n, sb, parenthesis);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(")");
            genValidParenthesis(open, close + 1, n, sb, parenthesis);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        genValidParenthesis(0, 0, n, new StringBuilder(), parenthesis);
        return parenthesis;
    }
}
