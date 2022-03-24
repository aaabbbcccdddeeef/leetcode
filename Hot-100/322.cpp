//
// Created by 刘志成 on 2022/2/7.
//
#include <bits/stdc++.h>
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(),coins.end());
        vector<int> dp (amount+1, -1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int m=INT_MAX;
            for(int j:coins){
                if(i>=j){
                    m=min(m,dp[i-j]);
                }else{
                    break;
                }
            }
            if(m==INT_MAX || m==-1){
                dp[i]=-1;
            }else{
                dp[i]=m+1;
            }
        }
        return dp[amount];
    }
};
int main(){
    vector<int> v={186,419,83,408};
    Solution().coinChange(v,6249);
    return 0;
}