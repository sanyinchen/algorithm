# 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
# 
#  下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
# 一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
# , col + 1) 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
# 输出：13
# 解释：如图所示，为和最小的两条下降路径
#  
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：matrix = [[-19,57],[-40,-5]]
# 输出：-59
# 解释：如图所示，为和最小的下降路径
#  
# 
#  
# 
#  提示： 
# 
#  
#  n == matrix.length == matrix[i].length 
#  1 <= n <= 100 
#  -100 <= matrix[i][j] <= 100 
#  
# 
#  Related Topics 数组 动态规划 矩阵 👍 342 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        # print(row, col)
        self.dp = [[sys.maxsize for _ in range(col)] for _ in range(row)]
        for i in range(len(matrix[0])):
            self.minFallingPathSumHelper(matrix, 0, i)
        return min(self.dp[0])

    def minFallingPathSumHelper(self, matrix: List[List[int]], row: int, col: int) -> int:
        if col < 0:
            return sys.maxsize
        if col >= len(matrix[0]):
            return sys.maxsize
        if row >= len(matrix):
            return sys.maxsize
        if self.dp[row][col] != sys.maxsize:
            return self.dp[row][col]

        pre_min = min(self.minFallingPathSumHelper(matrix, row + 1, col - 1),
                      self.minFallingPathSumHelper(matrix, row + 1, col),
                      self.minFallingPathSumHelper(matrix, row + 1, col + 1))
        if pre_min == sys.maxsize:
            self.dp[row][col] = matrix[row][col]
        else:
            self.dp[row][col] = matrix[row][col] + pre_min
        # print(row, col, matrix[row][col], self.dp)
        return self.dp[row][col]


# leetcode submit region end(Prohibit modification and deletion)


s = Solution()
# matrix = [[-62, -63, 23, 31], [-5, -82, 52, 76], [85, 69, 80, 85], [8, -22, 41, -45]]
matrix = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]
# matrix = [[51, 24], [-50, 82]]
# matrix = [[-19, 57], [-40, -5]]
# matrix = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]
print(s.minFallingPathSum(matrix))
