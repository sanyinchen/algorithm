# 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
# 
#  你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
# 
#  请你计算并返回达到楼梯顶部的最低花费。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：cost = [10,15,20]
# 输出：15
# 解释：你将从下标为 1 的台阶开始。
# - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
# 总花费为 15 。
#  
# 
#  示例 2： 
# 
#  
# 输入：cost = [1,100,1,1,1,100,1,1,100,1]
# 输出：6
# 解释：你将从下标为 0 的台阶开始。
# - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
# - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
# - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
# - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
# - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
# - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
# 总花费为 6 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  2 <= cost.length <= 1000 
#  0 <= cost[i] <= 999 
#  
# 
#  Related Topics 数组 动态规划 👍 1475 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        self.dp = [sys.maxsize for _ in range(len(cost))]
        self.max = len(cost)
        self.minCostClimbingStairsHelper(cost, 0)
        # print(self.dp)
        return min(self.dp[0], self.dp[1])

    def minCostClimbingStairsHelper(self, cost: List[int], index: int) -> int:
        if index >= self.max:
            return 0
        if self.dp[index] != sys.maxsize:
            return self.dp[index]

        self.dp[index] = cost[index] + min(self.minCostClimbingStairsHelper(cost, index + 1),
                                           self.minCostClimbingStairsHelper(cost, index + 2))
        return self.dp[index]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
test = [10, 15, 20]
print(s.minCostClimbingStairs(test))
