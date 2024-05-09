# 给定一个未排序的整数数组
#  nums ， 返回最长递增子序列的个数 。 
# 
#  注意 这个数列必须是 严格 递增的。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: [1,3,5,4,7]
# 输出: 2
# 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
#  
# 
#  示例 2: 
# 
#  
# 输入: [2,2,2,2,2]
# 输出: 5
# 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
#  
# 
#  
# 
#  提示: 
# 
#  
#  
# 
#  
#  1 <= nums.length <= 2000 
#  -10⁶ <= nums[i] <= 10⁶ 
#  
# 
#  Related Topics 树状数组 线段树 数组 动态规划 👍 865 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
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
            max_times = 1
            for i in range(end):
                if nums[i] < nums[end]:
                    pre = dfs(i)
                    if max_v < (pre[0] + 1):
                        max_v = pre[0] + 1
                        max_times = pre[1]
                    elif max_v == (pre[0] + 1):
                        max_times += pre[1]

            dp[end][0] = max_v
            dp[end][1] = max_times
            return dp[end]

        max_v = [-1, 0]
        for i in range(0, len(nums)):
            cur = dfs(i)
            if max_v[0] < cur[0]:
                max_v = list(cur)
            elif max_v[0] == cur[0]:
                max_v[1] += cur[1]
        return max_v[1]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 3, 5, 4, 7, 0]
nums = [2, 2, 2, 2, 2]
nums = [1, 1, 1, 2, 2, 2, 3, 3, 3, 0]
# nums = [1, 2, 4, 3, 5, 4, 7, 2]
# nums = [1, 2, 3]
print(s.findNumberOfLIS(nums))
