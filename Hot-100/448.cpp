//
// Created by 刘志成 on 2022/2/9.
//
#include <bits/stdc++.h>
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n=nums.size();
        for(int i:nums){
            nums[(i-1)%n]+=n;
        }
        vector<int> ans;
        for(int i=0;i<n;i++){
            if(nums[i]<=n){
                ans.push_back(i+1);
            }
        }
        return ans;
    }
};
int main(){
    vector<int> v{2,2};
    Solution().findDisappearedNumbers(v);
    return 0;
}