class Solution:
    def longestPalindrome(self, s: str) -> str:
        left, right = 0, 0
        for i in range(len(s)):
            a, b = self.expandPalindrome(s, i, i)
            c, d = self.expandPalindrome(s, i, i+1)
            if b-a > right-left:
                left = a
                right = b
            if d-c > right-left:
                left = c
                right = d
        return s[left:right]

    def expandPalindrome(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return left+1, right-1
