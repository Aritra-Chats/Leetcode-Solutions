class Solution {
    private void generateCombinations(int idx, String digits, StringBuilder sb, List<String> combinations, String[] numpad) {
        if(idx == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        int digit = digits.charAt(idx) - '0';
        String chars = numpad[digit];
        int len = chars.length();
        for(int i = 0; i < len; i++) {
            sb.append(chars.charAt(i));
            generateCombinations(idx + 1, digits, sb, combinations, numpad);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0) return combinations;
        String[] numpad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generateCombinations(0, digits, new StringBuilder(), combinations, numpad);
        return combinations;
    }
}
