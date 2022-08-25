class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = set()
        left, right = 0, 0
        ans = 0
        while right < len(s):
            while s[right] in cnt:
                cnt.remove(s[left])
                left += 1
            cnt.add(s[right])
            right += 1
            ans = max(ans, right-left)
        return ans


Solution().lengthOfLongestSubstring(" ")
