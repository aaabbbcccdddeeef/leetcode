from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = list()

        def backTrack(s, leftCnt, rightCnt):
            if leftCnt == n and rightCnt == n:
                ans.append(s)
                return
            if rightCnt == leftCnt or leftCnt < n:
                backTrack(s+"(", leftCnt+1, rightCnt)
            if rightCnt < leftCnt:
                backTrack(s+")", leftCnt, rightCnt+1)
        backTrack("", 0, 0)
        return ans
