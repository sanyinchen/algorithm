# 给你一个整数数组 nums ，你可以对它进行一些操作。 
# 
#  每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
#  + 1 的元素。 
# 
#  开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [3,4,2]
# 输出：6
# 解释：
# 删除 4 获得 4 个点数，因此 3 也被删除。
# 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [2,2,3,3,3,4]
# 输出：9
# 解释：
# 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
# 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
# 总共获得 9 个点数。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 2 * 10⁴ 
#  1 <= nums[i] <= 10⁴ 
#  
# 
#  Related Topics 数组 哈希表 动态规划 👍 932 👎 0
from typing import List, Tuple


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.dp = []

    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        new_nums = []
        self.dp = [-1 for _ in range(len(nums))]
        self.sum = {}
        for item in nums:
            if item in self.sum:
                self.sum[item] += item
            else:
                self.sum[item] = item
                new_nums.append(item)
        res = 0
        new_nums.sort()
        for i in range(len(new_nums)):
            res = max(self.deleteAndEarnHelper(new_nums, i), res)
        return res

    def deleteAndEarnHelper(self, nums: List[int], i: int) -> int:
        if i < 0:
            return 0
        if i >= len(nums):
            return 0
        if self.dp[i] != -1:
            return self.dp[i]
        pre_max = 0
        res = self.sum[nums[i]]
        # print(nums)
        for j in range(len(nums)):
            if nums[j] == nums[i] - 1 or nums[j] == nums[i] + 1:
                continue
            res += self.deleteAndEarnHelper(nums, j)
        self.dp[i] = res
        # self.dp[i] = max(self.deleteAndEarnHelper(nums, i - 1), self.deleteAndEarnHelper(nums, i + 1),
        #                  self.sum[nums[i]])
        return self.dp[i]


# leetcode submit region end(Prohibit modification and deletion)

s = Solution()
nums = [3, 4, 2]
nums = [2, 2, 3, 3, 3, 4]
# nums = [3, 1]
print(s.deleteAndEarn(nums))
