# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
# 被小偷闯入，系统会自动报警。 
# 
#  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：[1,2,3,1]
# 输出：4
# 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
#      偷窃到的最高金额 = 1 + 3 = 4 。 
# 
#  示例 2： 
# 
#  
# 输入：[2,7,9,3,1]
# 输出：12
# 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
#      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 100 
#  0 <= nums[i] <= 400 
#  
# 
#  Related Topics 数组 动态规划 👍 2975 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        self.dp = [-1 for _ in range(len(nums))]
        self.res = 0
        for i in range(len(nums)):
            self.res = max(self.res, self.rob_helper(nums, i))
        return self.res

    def rob_helper(self, nums: List[int], i: int) -> int:
        if i >= len(nums):
            return 0
        if self.dp[i] != -1:
            return self.dp[i]
        pre_max = 0
        for j in range(i + 2, len(nums), 1):
            pre_max = max(pre_max, self.rob_helper(nums, j))
        self.dp[i] = nums[i] + pre_max
        return self.dp[i]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
# nums = [1, 2, 3, 1]
# nums = [2, 7, 9, 3, 1]
nums = [2, 1, 1, 2]
print(s.rob(nums))
