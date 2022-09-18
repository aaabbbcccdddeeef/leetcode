from typing import List


class Solution:

    def sumPrefixScores(self, words: List[str]) -> List[int]:
        prefix_cnt = {}
        for word in words:
            for i in range(1, len(word) + 1):
                if word[:i] in prefix_cnt:
                    prefix_cnt[word[:i]] += 1
                else:
                    prefix_cnt[word[:i]] = 1
        res = [0] * len(words)
        for i, word in enumerate(words):
            for _ in range(1, len(word) + 1):
                res[i] += prefix_cnt[word[:_]]
        return res


print(Solution().sumPrefixScores(["abc", 'ab', 'bc', 'b']))
