from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        self.dp = [-1 for _ in range(len(nums))]
        max_v = -1
        for i in range(len(nums)):
            max_v = max(self.lengthOfLISHelper(nums, i), max_v)
        return max_v

    def lengthOfLISHelper(self, nums: List[int], index: int) -> int:
        # print(index)
        if self.dp[index] != -1:
            return self.dp[index]
        max_v = 1
        for i in range(index + 1):
            if nums[i] < nums[index]:
                max_v = max(self.lengthOfLISHelper(nums, i) + 1, max_v)
        # print(index, max_v)
        self.dp[index] = max_v
        return self.dp[index]


nums = [10, 9, 2, 5, 3, 7, 101, 18]
# nums = [1, 2, 3]
# nums = [3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12]
# nums = [7, 7, 7, 7, 7, 7, 7]
nums = [0, 1, 0, 3, 2, 3]
nums = [1, 3, 6, 7, 9, 4, 10, 5, 6]
s = Solution()
print(s.lengthOfLIS(nums))
