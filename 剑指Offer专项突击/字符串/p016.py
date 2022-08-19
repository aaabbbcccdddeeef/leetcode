class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        maxLen = 1
        start = 0
        end = 1
        while end < len(s):
            idx = s[start:end].find(s[end])
            if idx != -1:
                start += idx+1
            end += 1
            maxLen = max(maxLen, end-start)
        return maxLen


print("1"+Solution().lengthOfLongestSubstring("")+"1")
