from typing import List


class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stk = list()
        poppedIndex = 0
        for i in pushed:
            while stk and stk[-1] == popped[poppedIndex]:
                stk.pop()
                poppedIndex += 1
            stk.append(i)
        while stk and stk[-1] == popped[poppedIndex]:
            stk.pop()
            poppedIndex += 1
        return len(stk) == 0
