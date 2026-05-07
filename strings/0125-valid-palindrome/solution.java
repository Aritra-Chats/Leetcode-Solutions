class Solution {
    public boolean isAlphaNumeric(char ch) {
        return ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;
        while(left <= right) {
            char LeftChar = s.charAt(left);
            char RightChar = s.charAt(right);
            //Check for alphanumeric
            if(!isAlphaNumeric(LeftChar)) {
                left++;
                continue;
            }
            if(!isAlphaNumeric(RightChar)) {
                right--;
                continue;
            }

            //Check for equivalence
            if(Character.toLowerCase(LeftChar) != Character.toLowerCase(RightChar)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
