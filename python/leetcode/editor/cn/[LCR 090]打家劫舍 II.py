# 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同
# 时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
# 
#  给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [2,3,2]
# 输出：3
# 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [1,2,3,1]
# 输出：4
# 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
#      偷窃到的最高金额 = 1 + 3 = 4 。 
# 
#  示例 3： 
# 
#  
# 输入：nums = [0]
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 100 
#  0 <= nums[i] <= 1000 
#  
# 
#  
# 
#  
#  注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/ 
# 
#  Related Topics 数组 动态规划 👍 63 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rob(self, nums: List[int]) -> int:

        dp = [-1] * len(nums)

        def dfs(start: int, end) -> int:
            if dp[start] != -1:
                return dp[start]
            max_v = 0
            for i in range(start + 2, end):
                max_v = max(max_v, dfs(i, end))
            dp[start] = max_v + nums[start]
            return max_v

        # 选第一家
        max_v_1 = 0
        for i in range(len(nums) - 1):
            max_v_1 = max(max_v_1, dfs(i, len(nums) - 1))

        dp = [-1] * len(nums)
        # 不选第一家
        max_v_0 = 0
        for i in range(1, len(nums) - 1):
            max_v_0 = max(max_v_0, dfs(i, len(nums) - 1))
        print(max_v_1,max_v_0)
        return max(max_v_1, max_v_0 + nums[0], max_v_0 + nums[-1])


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
nums = [1, 2, 3, 1]
print(s.rob(nums))
