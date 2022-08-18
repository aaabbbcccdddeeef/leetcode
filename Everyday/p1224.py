from typing import Counter, List


class Solution:
    def maxEqualFreq(self, nums: List[int]) -> int:
        freq, cnt = Counter(), Counter()
        ans = maxFreq = 0
        for i, num in enumerate(nums):
            if cnt[num]:
                freq[cnt[num]] -= 1
            cnt[num] += 1
            freq[cnt[num]] += 1
            maxFreq = max(maxFreq, cnt[num])
            if maxFreq == 1 or\
                    freq[maxFreq] == 1 and maxFreq+freq[maxFreq-1]*(maxFreq-1) == i+1 or\
                    freq[maxFreq]*maxFreq+1 == i+1 and freq[1] == 1:
                ans = max(ans, i+1)
        return ans
