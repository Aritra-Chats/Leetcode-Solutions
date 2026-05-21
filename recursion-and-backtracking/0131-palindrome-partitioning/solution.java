class Solution {
    private boolean isPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
    private void generateSubstrings(int idx, int len, String s, List<String> iterator, List<List<String>> substrings) {
        if(idx == len) {
            substrings.add(new ArrayList<>(iterator));
            return;
        }
        for(int i = idx; i < len; i++) {
            if(isPalindrome(s.substring(idx, i + 1))) {
                iterator.add(s.substring(idx, i + 1));
                generateSubstrings(i + 1, len, s,iterator, substrings);
                iterator.remove(iterator.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> substrings = new ArrayList<>();
        generateSubstrings(0, s.length(), s, new ArrayList<>(), substrings);
        return substrings;
    }
}
