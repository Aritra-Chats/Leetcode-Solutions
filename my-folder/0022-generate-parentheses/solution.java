class Solution {

    private void generate(int open, int close, int n,
                          StringBuilder curr,
                          List<String> result) {

        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        // Add '('
        if (open < n) {
            curr.append('(');
            generate(open + 1, close, n, curr, result);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }

        // Add ')'
        if (close < open) {
            curr.append(')');
            generate(open, close + 1, n, curr, result);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        generate(0, 0, n, new StringBuilder(), result);

        return result;
    }
}
