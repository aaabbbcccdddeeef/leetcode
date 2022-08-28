class Solution:
    def preimageSizeFZF(self, k: int) -> int:
        # number of zeros after factorial of n
        def zeroNum(n: int) -> int:
            ans = 0
            while n > 0:
                ans += n//5
                n //= 5
            return ans

        # find the minimal x such that zeroNum(x)>=k
        def binSearch(k: int) -> int:
            left, right = 0, 5*k
            while left <= right:
                mid = (right+left)//2
                if zeroNum(mid) < k:
                    left = mid+1
                else:
                    right = mid-1
            return left

        return binSearch(k+1)-binSearch(k)
