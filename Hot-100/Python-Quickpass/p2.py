# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from asyncio.windows_events import NULL
from typing import Optional


class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummyHead = ListNode()
        cur = dummyHead
        carry = False
        while l1 != dummyHead and l2 != dummyHead:
            val = l1.val+l2.val+carry
            cur.next = ListNode((val) % 10)
            cur = cur.next
            carry = int(val/10)
            if l1 != dummyHead:
                l1 = l1.next
            if l2 != dummyHead:
                l2 = l2.next
            if l1 == None:
                l1 = dummyHead
            if l2 == None:
                l2 = dummyHead
        if carry:
            cur.next = ListNode(1)
        return dummyHead.next
