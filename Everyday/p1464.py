from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        a = max(nums)-1
        nums.remove(a+1)
        return a*(max(nums)-1)
