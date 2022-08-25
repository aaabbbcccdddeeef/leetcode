from bisect import bisect_left
from turtle import left, right
from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        if n < k:
            return []
        if n == k:
            return arr
        right = bisect_left(arr, x)
        left = right-1
        for _ in range(k):
            if left < 0:
                right += 1
            elif right >= n or x-arr[left] <= arr[right]-x:
                left -= 1
            else:
                right += 1
        return arr[left+1:right]


arr = [-5, -3, 3, 4, 5]
print(Solution().findClosestElements(arr, 4, 3))
