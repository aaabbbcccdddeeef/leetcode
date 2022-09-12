from typing import Counter, List


class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        lst = cnt.most_common()
        res = 1000_000
        maxCnt = 0
        for i in lst:
            if i[0] % 2 == 0:
                if maxCnt <= i[1] and i[0] < res:
                    res = i[0]
                    maxCnt = i[1]
        return -1 if res == 1000_000 else res


Solution().mostFrequentEven([8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290])
