from functools import lru_cache
from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        dp = [[-1, 1] for _ in range(len(nums))]

        def dfs(end: int) -> [int, int]:
            if dp[end][0] != -1:
                return dp[end]
            max_v = 1
            pre_max = [-1, -1]
            for i in range(end):
                if nums[i] < nums[end]:
                    pre = dfs(i)
                    if pre_max[0] <= pre[0]:
                        if pre_max[0] == pre[0]:
                            pre_max = pre
                            pre_max[1] += 1
                        else:
                            pre_max = pre

                    cur = pre_max[0] + 1
                    max_v = max(cur, max_v)

            dp[end][0] = max_v
            # print(dp[end], pre_max)
            # print(end, dp)
            dp[end][1] = max(pre_max[1], dp[end][1])
            # print('==>', dp)
            return dp[end]

        max_v = [-1, 0]
        for i in range(0, len(nums)):
            cur = dfs(i)
            print('cur', i, cur)
            if max_v[0] <= cur[0]:
                max_v = list(cur)
            # elif max_v[0] == cur[0]:
            #     max_v[1] += cur[1]
            # print('max', max_v)
        print(dp)
        return max_v[1]


s = Solution()
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
nums = [1, 3, 5, 4, 7, 0]
nums = [2, 2, 2, 2, 2]
nums = [1, 1, 1, 2, 2, 2, 3, 3, 3, 0]
print(s.findNumberOfLIS(nums))
