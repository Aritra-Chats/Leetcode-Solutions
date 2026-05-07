class Solution {
    private void generate(int curr, int n, String str, ArrayList<String> valid) {
        if(curr == n) {
            valid.add(str);
            return;
        }
        generate(curr + 1, n, str + "1", valid);
        if(str.length() == 0 || str.charAt(str.length() - 1) != '0')
            generate(curr + 1, n, str + "0", valid);
    }
    public List<String> validStrings(int n) {
        ArrayList<String> valid = new ArrayList<>();
        generate(0, n, "", valid);
        return valid;
    }
}
