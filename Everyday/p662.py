from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        map = {}

        def dfs(root: Optional[TreeNode], index: int, depth: int) -> None:
            if root == None:
                return 0
            if depth not in map:
                map[depth] = index
            ans = index-map.get(depth)+1
            return max(dfs(root.left, index << 1, depth+1),
                       dfs(root.right, (index << 1) | 1, depth+1),
                       ans)
        return dfs(root, 1, 0)
