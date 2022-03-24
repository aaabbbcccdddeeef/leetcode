//
// Created by 刘志成 on 2022/2/14.
// 查找数据流中的中位数：push元素的同时需要快速找到中位数。
// 建立一个最大堆，一个最小堆。最大堆所有堆元素小于最小堆里所有的元素。
// 最大堆的size等于最小堆的size，或者比最小堆的size大1
#include <bits/stdc++.h>
class MedianFinder {
    priority_queue<int, vector<int>, less<>> maxHeap;
    priority_queue<int, vector<int>, greater<>> minHeap;
public:
    MedianFinder()= default;
    void addNum(int num) {
        if(maxHeap.size()>minHeap.size()){
            if(!maxHeap.empty() && num<maxHeap.top()){
                maxHeap.push(num);
                num=maxHeap.top();
                maxHeap.pop();
            }
            minHeap.push(num);
        }else{
            if(!minHeap.empty() && num> minHeap.top()){
                minHeap.push(num);
                num=minHeap.top();
                minHeap.pop();
            }
            maxHeap.push(num);
        }
    }

    double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return (double)maxHeap.top();
        }else{
            return (double)(maxHeap.top()+minHeap.top())/2;
        }
    }
};
int main(){
    MedianFinder m;
    m.addNum(1);
    m.addNum(2);
    cout<<m.findMedian()<<endl;
    m.addNum(3);
    cout<<m.findMedian()<<endl;
    return 0;
}