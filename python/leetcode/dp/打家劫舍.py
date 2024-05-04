from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        self.dp = [-1 for _ in range(len(nums))]

        max_v = 0
        for i in range(len(nums)):
            max_v = max(self.rob_helper(nums, i), max_v)
        return max_v

    def rob_helper(self, nums: List[int], index: int) -> int:
        if index >= len(nums):
            return 0
        if self.dp[index] != -1:
            return self.dp[index]
        max_v = 0
        for i in range(index + 2, len(nums)):
            max_v = max(max_v, self.rob_helper(nums, i))
        # print(index, max_v, max_v + nums[index])
        self.dp[index] = max_v + nums[index]
        return self.dp[index]


s = Solution()
nums = [2, 1, 1, 2]
print(s.rob(nums))
