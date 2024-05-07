from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        self.memo = {}

        self.lengthOfLISHelper(nums, [], 0)
        return -1

    def lengthOfLISHelper(self, nums: List[int], sub: List[int], index: int):
        if index >= len(nums):
            return

        max_v = 0
        for i in range(index, len(nums)):
            if len(sub) > 0 and nums[i] <= sub[-1]:
                continue
            sub.append(nums[i])
            self.lengthOfLISHelper(nums, sub, i + 1)
            print('[', len(sub), ']', i, sub)
            max_v = max(max_v, len(sub))
            sub.pop()

        return


nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 2, 3]
s = Solution()
s.lengthOfLIS(nums)
