# 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
#  -1。 
# 
#  你可以认为每种硬币的数量是无限的。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：coins = [1, 2, 5], amount = 11
# 输出：3 
# 解释：11 = 5 + 5 + 1 
# 
#  示例 2： 
# 
#  
# 输入：coins = [2], amount = 3
# 输出：-1 
# 
#  示例 3： 
# 
#  
# 输入：coins = [1], amount = 0
# 输出：0
#  
# 
#  示例 4： 
# 
#  
# 输入：coins = [1], amount = 1
# 输出：1
#  
# 
#  示例 5： 
# 
#  
# 输入：coins = [1], amount = 2
# 输出：2
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= coins.length <= 12 
#  1 <= coins[i] <= 2³¹ - 1 
#  0 <= amount <= 10⁴ 
#  
# 
#  
# 
#  
#  注意：本题与主站 322 题相同： https://leetcode-cn.com/problems/coin-change/ 
# 
#  Related Topics 广度优先搜索 数组 动态规划 👍 101 👎 0

# leetcode submit region begin(Prohibit modification and deletion)
import sys
from typing import List


class Solution:
    def __init__(self):
        self.cache = {}

    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        self.cache = {}
        res_min = self.coinChangeExtra(coins, amount, 0)
        return -1 if res_min == sys.maxsize else res_min

    def coinChangeExtra(self, coins: List[int], amount: int, number: int) -> int:
        minNumber = sys.maxsize
        if amount == 0:
            return minNumber
        if self.cache.__contains__(amount):
            return self.cache[amount]
        for j in range(len(coins)):
            coin = coins[j]
            if amount < coin:
                continue
            amount -= coin
            if amount == 0:
                minNumber = min(number + 1, minNumber)
            res_minNumber = self.coinChangeExtra(coins, amount, number + 1)
            size = amount // coin
            for i in range(size, 0, -1):
                amount -= coin * i
                number += i
                if amount == 0:
                    minNumber = min(number, minNumber)
                res_minNumber = self.coinChangeExtra(coins[j + 1:], amount, number)
                minNumber = min(res_minNumber, minNumber)
                amount += coin * i
                number -= i
        self.cache[amount] = minNumber
        return minNumber


# leetcode submit region end(Prohibit modification and deletion)


s = Solution()
print(s.coinChange([186, 419, 83, 408], 6249))

# print(s.coinChange([1, 3, 5], 8))

# print(s.coinChange([3, 7, 405, 436], 8839))
# print(s.coinChange([1, 5, 2], 11))
# print(s.coinChange([1], 0))
