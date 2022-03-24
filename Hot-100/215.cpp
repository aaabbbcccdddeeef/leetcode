//
// Created by 刘志成 on 2022/2/14.
//
// implementation of max-binary-heap
#include <bits/stdc++.h>
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int size=(int)nums.size();
        buildHeap(nums,size);
        while(k-->1){
            nums[0]=nums[size-1];
            size--;
            percolateDown(nums,0,size);
        }
        return nums[0];
    }
    void buildHeap(vector<int>&nums, int size){
        for(int i=size/2; i>=0;i--){
            percolateDown(nums,i,size);
        }
    }
    void percolateDown(vector<int>& nums, int i, int size){
        int l=i*2+1, r=l+1, largest=i;
        if(l<size && nums[l]>nums[largest]) largest=l;
        if(r<size && nums[r]>nums[largest]) largest=r;
        if(largest!=i){
            swap(nums[largest],nums[i]);
            percolateDown(nums,largest,size);
        }
    }
};
int main(){
    vector<int> v {3,2,3,1,2,4,5,5,6};
    cout<<Solution().findKthLargest(v,4)<<endl;
    return 0;
}