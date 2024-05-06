from functools import lru_cache
from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        dp = [[[] for _ in range(len(nums))] for _ in range(len(nums))]

        # print(dp)

        def dfs(end: int) -> int:
            max_v = 1
            for i in range(end):
                if len(dp[i][end]) != 0:
                    max_v = max(dp[i][end][0], max_v)
                    continue
                if nums[i] < nums[end]:
                    max_v = max(dfs(i) + 1, max_v)
                    if len(dp[i][end]) == 0:
                        dp[i][end].append(max_v)
                        dp[i][end].append(1)
                    else:
                        dp[i][end][1] += 1

                # print(i, end, max_v)

            return max_v

        for i in range(0, len(nums)):
            dfs(i)

        max_v = 0
        max_times = 0
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if len(dp[i][j]) == 0:
                    continue
                if max_v == dp[i][j][0]:
                    max_times += 1
                if max_v < dp[i][j][0]:
                    max_times = 1
                    max_v = dp[i][j][0]

        return max_times


s = Solution()
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
nums = [1, 3, 5, 4, 7]
print(s.findNumberOfLIS(nums))
