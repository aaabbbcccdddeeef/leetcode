//
// Created by liu on 3/3/2022.
//
#include <bits/stdc++.h>
using namespace std;
/* Definition for singly-linked list.*/
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    explicit ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int,vector<int>,greater<>> q;
        for(auto lst:lists){
            ListNode*p=lst;
            while(p){
                q.emplace(p->val);
                p=p->next;
            }
        }
        auto* dummyHead=new ListNode(0);
        ListNode* p=dummyHead;
        while(!q.empty()){
            int tmp=q.top();
            p->next=new ListNode(tmp);
            q.pop();
            p=p->next;
        }
        p=dummyHead->next;
        delete(dummyHead);
        return p;
    }
    ListNode* merge(ListNode* l1, ListNode* l2){
        auto* dummyHead=new ListNode(0);
        ListNode* p=dummyHead;
        while (l1 && l2){
            if(l1->val>l2->val){
                p->next=l2;
                l2=l2->next;
            }else{
                p->next=l1;
                l1=l1->next;
            }
            p=p->next;
        }
        p->next=l1?l1:l2;
        p=dummyHead->next;
        delete(dummyHead);
        return p;
    }
};