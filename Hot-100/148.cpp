 struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head){
            return head;
        }
        int len=0;
        ListNode* temp=head;
        while (temp){
            len++;
            temp=temp->next;
        }
        ListNode* dummyHead=new ListNode(0,head);
        for(int subLen=1; subLen<len; subLen<<=1){
            ListNode* prev=dummyHead, *curr=dummyHead->next;
            while(curr){
                // find the first subList head
                ListNode* head1=curr;
                // find the second subList head
                for(int i=1;i<subLen && curr->next;i++){
                    curr=curr->next;
                }
                // curr now point to last item of sub_list1
                ListNode* head2=curr->next;
                curr->next= nullptr;
                curr=head2;
                // find where sub_list2 ends
                for(int i=1;i<subLen && curr && curr->next;i++){
                    curr=curr->next;
                }
                ListNode* next=nullptr;
                if(curr){
                    next=curr->next;
                    curr->next=nullptr;
                }
                ListNode* merged= merge(head1,head2);
                prev->next=merged;
                while (prev->next){
                    prev=prev->next;
                }
                curr=next;
            }
        }
        return dummyHead->next;
    }
    ListNode* merge(ListNode* head1, ListNode* head2){
        ListNode* dummyHead=new ListNode(0);
        ListNode* temp=dummyHead, *temp1=head1, *temp2=head2;
        while (temp1 && temp2){
            if(temp1->val<=temp2->val){
                temp->next=head1;
                temp1=temp1->next;
            }else{
                temp->next=head2;
                temp2=temp2->next;
            }
            temp=temp->next;
        }
        if(temp1){
            temp->next=temp1;
        }
        if(temp2){
            temp->next=temp2;
        }
        temp=dummyHead->next;
        delete(dummyHead);
        return temp;
    }
};