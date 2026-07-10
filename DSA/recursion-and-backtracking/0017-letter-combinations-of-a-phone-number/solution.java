class Solution {
    private void generateCombinations(int idx, String digits, String[] keypad, StringBuilder sb, List<String> combinations) {
        if(idx == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        int digit = digits.charAt(idx) - '2';
        for(char ch : keypad[digit].toCharArray()) {
            sb.append(ch);
            generateCombinations(idx + 1, digits, keypad, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] keypad = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateCombinations(0, digits, keypad, sb, combinations);
        return combinations;
    }
}
