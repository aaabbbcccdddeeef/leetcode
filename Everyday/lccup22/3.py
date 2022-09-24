from functools import lru_cache
from typing import List


class Solution:

    def __init__(self) -> None:
        self.plate = []
        self.n = 0
        self.m = 0

    def p(self, i, j):
        return self.plate[i][j]

    @lru_cache()
    def go(self, i, j, k, dir):
        if i >= self.n or i < 0 or j >= self.m or j < 0:
            return False
        if k >= 0:
            if self.p(i, j) == 'O':
                return True
        if k == 0:
            return False
        it, jt = i, j
        if self.p(i, j) == '.':
            if dir == 0:
                it -= 1
            elif dir == 1:
                jt += 1
            elif dir == 2:
                it += 1
            else:
                jt -= 1
            return self.go(it, jt, k - 1, dir)
        elif self.p(i, j) == 'W':
            if dir == 0:
                jt -= 1
            elif dir == 1:
                it -= 1
            elif dir == 2:
                jt += 1
            else:
                it += 1
            return self.go(it, jt, k - 1, (dir - 1) % 4)
        else:
            if dir == 0:
                jt += 1
            elif dir == 1:
                it += 1
            elif dir == 2:
                jt -= 1
            else:
                it -= 1
            return self.go(it, jt, k - 1, (dir + 1) % 4)

    def ballGame(self, num: int, plate: List[str]) -> List[List[int]]:
        self.plate = plate
        self.n, self.m = len(plate), len(plate[0])
        res = []
        for j in range(1, self.m - 1):
            if self.p(0, j) == '.':
                if self.go(0, j, num, 2):
                    res.append([0, j])
            if self.p(self.n - 1, j) == '.':
                if self.go(self.n - 1, j, num, 0):
                    res.append([self.n - 1, j])
        for i in range(1, self.n - 1):
            if self.p(i, 0) == '.':
                if self.go(i, 0, num, 1):
                    res.append([i, 0])
            if self.p(i, self.m - 1) == '.':
                if self.go(i, self.m - 1, num, 3):
                    res.append([i, self.m - 1])
        return res


plate = [
    "E...W..WW", ".E...O...", "...WO...W", "..OWW.O..", ".W.WO.W.E",
    "O..O.W...", ".OO...W..", "..EW.WEE."
]
print(Solution().ballGame(41, plate))
