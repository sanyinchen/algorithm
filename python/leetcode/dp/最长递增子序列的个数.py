from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        self.dp = [-1 for _ in range(len(nums))]
        self.memo = {}
        max_v = -1
        for i in range(len(nums)):
            max_v = max(self.dfs(nums, i), max_v)
        return self.memo[max_v]

    def dfs(self, nums: List[int], index: int) -> int:
        if self.dp[index] != -1:
            return self.dp[index]

        max_v = 1
        for i in range(index + 1):
            if nums[i] < nums[index]:
                max_v = max(self.dfs(nums, i) + 1, max_v)
                if max_v in self.memo:
                    self.memo[max_v] += 1
                else:
                    self.memo[max_v] = 1
            else:
                self.memo[max_v] = 1
        # print(index, max_v)
        self.dp[index] = max_v
        return self.dp[index]


s = Solution()
nums = [1]
nums = [1, 2, 4, 3, 5, 4, 7, 2]
print(s.findNumberOfLIS(nums))
