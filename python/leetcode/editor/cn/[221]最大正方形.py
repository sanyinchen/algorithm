# 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
# ,["1","0","0","1","0"]]
# 输出：4
#  
# 
#  示例 2： 
#  
#  
# 输入：matrix = [["0","1"],["1","0"]]
# 输出：1
#  
# 
#  示例 3： 
# 
#  
# 输入：matrix = [["0"]]
# 输出：0
#  
# 
#  
# 
#  提示： 
# 
#  
#  m == matrix.length 
#  n == matrix[i].length 
#  1 <= m, n <= 300 
#  matrix[i][j] 为 '0' 或 '1' 
#  
# 
#  Related Topics 数组 动态规划 矩阵 👍 1654 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # if len(matrix) == 1:
        #     if sum(map(int, matrix[0])) > 0:
        #         return 1
        #     else:
        #         return 0
        self.dp = [[-1 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        # self.dp = []
        # for i in range(len(matrix)):
        #     self.dp.append([])
        #     for j in range(len(matrix[i])):
        #         self.dp[i].append(-1)
        # print(self.dp)
        return self.maximalSquareHelper(matrix, 0, 0)

    def getMatrix(self, matrix: List[List[str]], i, j) -> int:
        res = 0
        stop = False
        for m_len in range(1, min(len(matrix[0]), len(matrix)) + 1):
            sum_m = 0
            for i2 in range(i, min(i + m_len, len(matrix))):
                for j2 in range(j, min(j + m_len, len(matrix[0]))):
                    if matrix[i2][j2] == '0':
                        stop = True
                        break
                    sum_m += int(matrix[i2][j2])
                if stop:
                    break
            if sum_m == m_len * m_len:
                res = m_len
            else:
                break
        # print(i, j, res)
        return res * res

    def maximalSquareHelper(self, matrix: List[List[str]], i: int, j: int) -> int:
        if i >= len(matrix) or j >= len(matrix[i]):
            return 0
        if matrix[i][j] == 0:
            return 0
        if self.dp[i][j] != -1:
            return self.dp[i][j]
        cur = matrix[i][j]
        left = self.maximalSquareHelper(matrix, i + 1, j)
        down = self.maximalSquareHelper(matrix, i, j + 1)
        diagonal = self.maximalSquareHelper(matrix, i + 1, j + 1)
        if cur == '1':
            self.dp[i][j] = 1
            if left
        else:
            self.dp[i][j] = 0

        return self.dp[i][j]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]
# matrix = [["0", "1"], ["1", "0"]]
matrix = [["1", "1"], ["1", "1"]]
# matrix = [["1"]]
print(s.maximalSquare(matrix))
