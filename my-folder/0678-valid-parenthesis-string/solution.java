class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0, length = s.length();
        for(int i = 0; i < length; i++) {
            switch(s.charAt(i)) {
                case '(':
                    low++;
                    high++;
                    break;
                case ')':
                    low--;
                    high--;
                    if (high < 0) 
                        return false;
                    if (low < 0)
                        low = 0;
                    break;
                case '*':
                    low--;
                    high++;
                    if (low < 0)
                        low = 0;
            }
        }
        return low == 0;
    }
}
