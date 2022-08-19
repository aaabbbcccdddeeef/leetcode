class Solution:
    def validPalindrome(self, s: str) -> bool:
        n = len(s)
        sR = s[::-1]
        if s == sR:
            return True
        for i in range(n):
            if s[i] != sR[i]:
                ans1 = s[:i]+s[i+1:]
                ans2 = sR[:i]+sR[i+1:]
                if ans1 == ans1[::-1] or ans2 == ans2[::-1]:
                    return True
                else:
                    return False
        return True
