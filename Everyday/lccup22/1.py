from typing import List


class Solution:

    def temperatureTrend(self, ta: List[int], tb: List[int]) -> int:
        res = 0
        p = 1
        minLen = min(len(ta), len(tb))
        while p < minLen:
            tmp_res = 0
            while (p < minLen) and (
                (ta[p] - ta[p - 1] > 0 and tb[p] - tb[p - 1] > 0) or
                (ta[p] - ta[p - 1] == 0 and tb[p] - tb[p - 1] == 0) or
                (ta[p] - ta[p - 1] < 0 and tb[p] - tb[p - 1] < 0)):
                tmp_res += 1
                p += 1
            p += 1
            res = max(res, tmp_res)
        return res


ta = [5, 10, 16, -6, 15, 11, 3]
tb = [16, 22, 23, 23, 25, 3, -16]
print(Solution().temperatureTrend(ta, tb))
