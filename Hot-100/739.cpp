//
// Created by 刘志成 on 2022/2/7.
//
#include <bits/stdc++.h>
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        stack<int> stk;
        vector<int> ans (t.size(),0);
        for(int i=0;i<t.size();i++){
            if(stk.empty()){
                stk.push(i);
                continue;
            }
            while(!stk.empty() && t[stk.top()]<t[i]){
                ans[stk.top()]=i-stk.top();
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }
};
int main(){
    vector<int> v={73,74,75,71,69,72,76,73};
    Solution().dailyTemperatures(v);
}
