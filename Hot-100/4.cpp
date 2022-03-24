#include<bits/stdc++.h>

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int total_num=nums1.size()+nums2.size();
        int left_num=(total_num+1)/2;
        int left=0;
        int right=nums1.size();
        while(left<right){
            int k=left+(right-left+1)/2;
            int j=left_num-k;
            if(nums1[k-1]>nums2[j]){
                right=k-1;
            }else{
                left=k;
            }
        }
        cout<<'yes '<<left<<endl;
        int i=left;
        int j=left_num-i;
        int n1_leftMax=i?nums1[i-1]:-1e6;
        int n1_rightMin=i==nums1.size()?1e6:nums1[i];
        int n2_leftMax=j?nums2[j-1]:-1e6;
        int n2_rightMin=j==nums2.size()?1e6:nums2[j];
        cout<<n1_leftMax<<' '<<n1_rightMin<<' '<<n2_leftMax<<' '<<n2_rightMin<<endl;
            if(total_num%2){
            return max(n1_leftMax,n2_leftMax);
        }else{
            return (float)(max(n1_leftMax,n2_leftMax)+min(n1_rightMin,n2_rightMin))/2;
        }
    }
};

int main(){
    vector<int> num1 {1,3};
    vector<int> num2 {2};
    cout<<Solution().findMedianSortedArrays(num1,num2)<<endl;
}