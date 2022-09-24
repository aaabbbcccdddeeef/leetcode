from typing import List


class Solution:

    def transportationHub(self, path: List[List[int]]) -> int:
        map = {}
        for i in path:
            if i[0] in map:
                map[i[0]][1] += 1
            else:
                map[i[0]] = [0, 1]
            if i[1] in map:
                map[i[1]][0] += 1
            else:
                map[i[1]] = [1, 0]
        cnt = len(map) - 1
        for i in map.keys():
            if map[i][0] == cnt and map[i][1] == 0:
                return i
        print(map)
        return -1


path = [[0, 3], [1, 0], [1, 3], [2, 0], [3, 0], [3, 2]]
print(Solution().transportationHub(path))