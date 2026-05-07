class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int len = s.length();
        int[] a = new int[256], b = new int[256];
        for(int i = 0; i < len; i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if(a[cs] != b[ct]) 
                return false;
            a[cs]=i+1;
            b[ct]=i+1;
        }
        return true;
    }
}
