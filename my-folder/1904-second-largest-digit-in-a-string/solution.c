int secondHighest(char* s) {
    int hash[10];
    for(int i = 0;i < strlen(s); i++) {
        if(s[i] >= '0' && s[i] <= '9') hash[s[i]-'0'] = 1;
    }
    int count = 0, index;
    for(int i = 9; i >= 0; i--) {
        if(hash[i] == 1) {
            count++;
            index = i;
            if(count == 2) break;
        }
    }
    return (count == 2) ? index : -1;
}
