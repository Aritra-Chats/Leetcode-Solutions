#pragma GCC target("avx,mmx,sse2,sse3,sse4")
auto _=[]()noexcept{ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);return 0;}();
class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        long int L=0, R=0, res=0, total=0;
        while(R<nums.size()) {
            total+=nums[R];
            while(nums[R]*(R-L+1)>total+k) {
                total-=nums[L];
                L++;
            }
            res = max(res,R-L+1);
            R++;
        }
        return res;
    }
};
