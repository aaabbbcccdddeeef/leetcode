class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = "".join(o.lower() for o in s if o.isalnum())
        return s == s[::-1]
