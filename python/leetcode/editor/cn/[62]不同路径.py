# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
# 
#  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
# 
#  问总共有多少条不同的路径？ 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：m = 3, n = 7
# 输出：28 
# 
#  示例 2： 
# 
#  
# 输入：m = 3, n = 2
# 输出：3
# 解释：
# 从左上角开始，总共有 3 条路径可以到达右下角。
# 1. 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右
# 3. 向下 -> 向右 -> 向下
#  
# 
#  示例 3： 
# 
#  
# 输入：m = 7, n = 3
# 输出：28
#  
# 
#  示例 4： 
# 
#  
# 输入：m = 3, n = 3
# 输出：6 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= m, n <= 100 
#  题目数据保证答案小于等于 2 * 10⁹ 
#  
# 
#  Related Topics 数学 动态规划 组合数学 👍 2021 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __int__(self):
        self.m = -1
        self.n = -1

    def uniquePaths(self, m: int, n: int) -> int:
        if m == 1 and n == 1:
            return 1
        self.m = m
        self.n = n
        self.dp = [[-1 for _ in range(self.m)] for _ in range(self.n)]
        return self.uniquePathsHelper(0, 0)

    def uniquePathsHelper(self, x: int, y: int) -> int:
        if x == self.n - 1 and y == self.m - 1:
            return 1
        if x >= self.n:
            return 0
        if y >= self.m:
            return 0
        if self.dp[x][y] != -1:
            return self.dp[x][y]
        self.dp[x][y] = self.uniquePathsHelper(x + 1, y) + self.uniquePathsHelper(x, y + 1)
        return self.dp[x][y]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.uniquePaths(3, 2))
