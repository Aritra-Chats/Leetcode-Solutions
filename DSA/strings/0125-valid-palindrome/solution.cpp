class Solution {
public:
    bool isPalindrome(string str) {
    string check = "";
    int count=0;
    for(int i=0;i<str.length();i++) {
            if(str[i] >= '0' && str[i] <= '9') check.push_back(str[i]);
            else {
                if(str[i]>='a' && str[i]<='z') check.push_back(str[i]);
                else if(str[i]>='A' && str[i]<='Z') {
                    str[i] += 32;
                    check.push_back(str[i]);
                }
            }
        }
    int n = check.length();
    for(int i=0;i<n;i++) {
        if(check[i]!=check[n-1-i]) {
            count++;
        }
    }
    if(count>0) return false;
    else return true;
}
};
