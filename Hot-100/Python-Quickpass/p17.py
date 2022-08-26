from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return list()
        phoneMap = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }

        def backTrack(index: int):
            if index == len(digits):
                ans.append("".join(combination))
            else:
                for letter in phoneMap[digits[index]]:
                    combination.append(letter)
                    backTrack(index+1)
                    combination.pop()
        combination = list()
        ans = list()
        backTrack(0)
        return ans
