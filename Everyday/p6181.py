class Solution:

    def longestContinuousSubstring(self, s: str) -> int:
        n = len(s)
        res = 0
        tmp = 1
        for i in range(1, n):
            if ord(s[i - 1]) + 1 == ord(s[i]):
                tmp += 1
            else:
                res = max(res, tmp)
                tmp = 1
        return max(res, tmp)


print(Solution().longestContinuousSubstring("abcabef"))
