//
// Created by liu on 2022/3/15.
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<bool> dp(nums.size(),true);
        return fill(nums, dp,0);
    }
    bool fill(vector<int>& nums, vector<bool>& dp, int i){
        // start from i can't jump to end
        if(!dp[i]){
            return false;
        }
        if(i==nums.size()-1){
            return true;
        }
        for(int j=1;j<nums[i] && i+j<nums.size();j++){
            if(fill(nums,dp,i+j)){
                return true;
            }
        }
        dp[i]=false;
        return false;
    }
};

int main(){
    vector<int> nums={2,3,1,1,4};
    cout<<Solution().canJump(nums)<<endl;
}