# 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
# 
#  说明：每次只能向下或者向右移动一步。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
# 输出：7
# 解释：因为路径 1→3→1→1→1 的总和最小。
#  
# 
#  示例 2： 
# 
#  
# 输入：grid = [[1,2,3],[4,5,6]]
# 输出：12
#  
# 
#  
# 
#  提示： 
# 
#  
#  m == grid.length 
#  n == grid[i].length 
#  1 <= m, n <= 200 
#  0 <= grid[i][j] <= 200 
#  
# 
#  Related Topics 数组 动态规划 矩阵 👍 1672 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:

        # print(self.m, self.n)
        self.dp = [[-1 for _ in range(len(grid[0]))] for _ in range(len(grid))]
        # print(self.dp)
        return self.minPathSumHelper(grid, 0, 0)

    def minPathSumHelper(self, grid: List[List[int]], i: int, j: int):
        if i == len(grid) - 1 and j == len(grid[0]) - 1:
            return grid[i][j]
        if i >= len(grid):
            return 200 * 200
        if j >= len(grid[0]):
            return 200 * 200
        if self.dp[i][j] != -1:
            return self.dp[i][j]
        self.dp[i][j] = grid[i][j]
        right = self.minPathSumHelper(grid, i + 1, j)
        down = self.minPathSumHelper(grid, i, j + 1)
        if right <= down:
            self.dp[i][j] += right
        else:
            self.dp[i][j] += down
        return self.dp[i][j]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
grid = [[1, 2, 3], [4, 5, 6]]
print(s.minPathSum(grid))
