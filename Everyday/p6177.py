class Solution:
    def partitionString(self, s: str) -> int:
        res = 0
        cnt = set()
        for ch in s:
            if ch in cnt:
                res += 1
                cnt = set()
            cnt.add(ch)
        return res+1

print(Solution().partitionString("ssssss"))
