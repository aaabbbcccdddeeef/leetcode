//
// Created by 刘志成 on 2022/2/21.
//
#include <bits/stdc++.h>
class Solution {
public:
    string longestPalindrome(string s) {
        int size=s.size();
        int maxLen=0, begin=0;
        for(int i=0; i<size-1; ++i){
            auto [l1, r1]=expand(s,i,i);
            auto [l2,r2]=expand(s,i,i+1);
            if(r1-l1+1>maxLen){
                maxLen=r1-l1+1;
                begin=l1;
            }
            if(r2-l2+1>maxLen){
                maxLen=r2-l2+1;
                begin=l2;
            }
        }
        return s.substr(begin,maxLen);
    }
    static pair<int,int> expand(const string& s, int left, int right){
        while(left>=0 && right<s.size() && s[left]==s[right]){
            left--;right++;
        }
        return {left+1,right-1};
    }
};
int main(){
    cout<<Solution().longestPalindrome("abbd")<<endl;
    return 0;
}