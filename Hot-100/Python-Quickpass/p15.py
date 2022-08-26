from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if n < 3:
            return []
        nums = sorted(nums)
        ans = []
        for first in range(n-2):
            if nums[first] > 0:
                break
            if first > 0 and nums[first] == nums[first-1]:
                continue
            second, third = first+1, n-1
            maxSum = nums[third]+nums[third-1]
            if maxSum < -nums[first]:
                continue
            minSum = nums[second]+nums[second+1]
            if minSum > -nums[first]:
                break
            while second < third:
                sum = nums[second]+nums[third]
                if sum == -nums[first]:
                    ans.append([nums[first], nums[second], nums[third]])
                    second += 1
                    third -= 1
                    while second < third and nums[second] == nums[second-1]:
                        second += 1
                    while second < third and nums[third] == nums[third+1]:
                        third -= 1
                elif sum < -nums[first]:
                    second += 1
                else:
                    third -= 1
        return ans


Solution().threeSum([-1, 0, 1])
