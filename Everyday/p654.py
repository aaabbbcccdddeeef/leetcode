from asyncio.windows_events import NULL
import this
from turtle import right
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        n = len(nums)
        nodes = [None]*n
        stk = []
        for i, num in enumerate(nums):
            nodes[i] = TreeNode(num, None, None)
            while stk and nums[stk[-1]] < num:
                nodes[i].left = nodes[stk[-1]]
                stk.pop()
            if stk:
                nodes[stk[-1]].right = nodes[i]
            stk.append(i)
        return nodes[stk[0]]
