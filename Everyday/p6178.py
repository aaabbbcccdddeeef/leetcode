from typing import List


class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        diff = [0]*1000_100
        for interval in intervals:
            diff[interval[0]] += 1
            diff[interval[1]+1] -= 1
        res = 0
        for i in range(1, 1000_010):
            diff[i] += diff[i-1]
            res = max(res, diff[i])
        return res
