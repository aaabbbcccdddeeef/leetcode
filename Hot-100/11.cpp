//
// Created by 刘志成 on 2022/2/22.
//
#include <bits/stdc++.h>
class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxAmout=0, l=0, r=height.size()-1;
        while(l<r){
            maxAmout=max(maxAmout,(r-l)*min(height[l],height[r]));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxAmout;
    }
};
int main(){
    vector<int> v={1,9,1};
    cout<<Solution().maxArea(v)<<endl;
    return 0;
}