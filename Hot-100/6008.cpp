//
// Created by 刘志成 on 2022/2/27.
//
#include <bits/stdc++.h>
class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int s=pref.size();
        int res=0;
        for(auto word:words){
            if(word.size()>=s){
                int i=0;
                for(i=0;i<s;++i){
                    if(pref[i]!=word[i]){
                        break;
                    }
                }
                if(i==s) res++;
            }
        }
        return res;
    }
};

int main(){
    vector<string> s={"pay","attention","practice","attend"};
    Solution().prefixCount(s,"at");
}