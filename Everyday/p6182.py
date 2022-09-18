# Definition for a binary tree node.
class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:

    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = [root]
        depth, level_cnt = 0, 1
        while queue:
            if depth & 1:
                # swap values
                for i in range(level_cnt // 2):
                    queue[i].val,queue[level_cnt-i-1].val=\
                        queue[level_cnt-i-1].val,queue[i].val
            depth += 1
            next_level_cnt = 0
            for i in range(level_cnt):
                node = queue.pop(0)
                if node.left is not None:
                    queue.append(node.left)
                    queue.append(node.right)
                    next_level_cnt += 2
            level_cnt = next_level_cnt
        return root


root = TreeNode(2, TreeNode(3, TreeNode(8), TreeNode(13)),
                TreeNode(5, TreeNode(21), TreeNode(34)))

print(Solution().reverseOddLevels(root))
