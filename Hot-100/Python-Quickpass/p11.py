from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height)-1
        maxH = max(height)
        ans = 0
        while left < right:
            ans = max(ans, (right-left)*min(height[right], height[left]))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
            if ans >= maxH*(right-left): # 剪枝，太妙了
                break
        return ans
