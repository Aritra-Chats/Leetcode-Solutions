class Solution {
public:
    bool isPalindrome(string str) {
    for(int i=0;i<str.length();i++) {
        if((str[i]<'A' || str[i] > 'Z') && (str[i] < 'a' || str[i] > 'z') && (str[i] < '0' || str[i] > '9')) {
            str.erase(i,1);
            i--;
        }
    }
    for(int i=0;i<str.length();i++) {
        if(str[i]>='A' && str[i]<='Z') {
            str[i]+=32;
        }
    }
    int n = str.length(),count=0;
    for(int i =0;i<n;i++) {
        if(str[i]!=str[n-1-i]) {
            count++;
        }
    }
    if(count>0) return false;
    else return true;
}
};
