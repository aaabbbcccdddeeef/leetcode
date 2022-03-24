//
// Created by 刘志成 on 2022/2/8.
//
#include <bits/stdc++.h>
class Solution {
public:
    int longestValidParentheses(string s) {
        if(!s.length()) return 0;
        vector<int> dp(s.length(),0);
        for(int i=1; i<s.length(); i++){
            if(s[i]==')'){
                if(dp[i-1]){
                    if(i-1-dp[i-1]>=0 && s[i-1-dp[i-1]]=='('){
                        dp[i]=dp[i-1]+2;
                        if(i-dp[i-1]-1>0){
                            dp[i]+=dp[i-dp[i-1]-2];
                        }
                    }else{
                        dp[i]=0;
                    }
                }else{
                    if(s[i-1]=='('){
                        dp[i]=2;
                    }
                    if(i>=2){
                        dp[i]+=dp[i-2];
                    }
                    if(s[i-1]==')'){
                        dp[i]=0;
                    }
                }
            }
        }
        return *max_element(dp.begin(),dp.end());
    }
};
int main(){
    cout<<Solution().longestValidParentheses("()(())")<<endl;
    return 0;
}