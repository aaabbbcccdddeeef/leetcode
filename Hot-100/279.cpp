//
// Created by 刘志成 on 2022/2/7.
//
#include <bits/stdc++.h>
class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n+1,n+1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=min(dp[i],dp[i-j*j]+1);
            }
            dp[i]=min(dp[i],dp[i-1]+1);
        }
        return dp[n];
    }
};
int main(){
    cout<<Solution().numSquares(13)<<endl;
    return 0;
}