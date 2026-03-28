class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), left = 0, subLength = 0;
        Set<Character> set = new HashSet<>(); 
        for(int right = 0; right < length; right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            subLength = Math.max(subLength, right - left + 1);
        }
        return subLength;
    }
}
