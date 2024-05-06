# 给定一个三角形 triangle ，找出自顶向下的最小路径和。 
# 
#  每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
# 正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
# 输出：11
# 解释：如下面简图所示：
#    2
#   3 4
#  6 5 7
# 4 1 8 3
# 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
#  
# 
#  示例 2： 
# 
#  
# 输入：triangle = [[-10]]
# 输出：-10
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= triangle.length <= 200 
#  triangle[0].length == 1 
#  triangle[i].length == triangle[i - 1].length + 1 
#  -10⁴ <= triangle[i][j] <= 10⁴ 
#  
# 
#  
# 
#  进阶： 
# 
#  
#  你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
#  
# 
#  Related Topics 数组 动态规划 👍 1335 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        self.dp = []
        for i in range(len(triangle)):
            tmp = []
            for j in range(len(triangle[i])):
                tmp.append(-1)
            self.dp.append(tmp)
        print(self.dp)
        return self.minimumTotalHelper(triangle, 0, 0)

    def minimumTotalHelper(self, triangle: List[List[int]], i, j):
        if i == len(triangle) - 1 and j < len(triangle[i]):
            return triangle[i][j]
        if i >= len(triangle):
            return sys.maxsize
        if j >= len(triangle[i]):
            return sys.maxsize
        if self.dp[i][j] != -1:
            return self.dp[i][j]
        self.dp[i][j] = triangle[i][j]
        down1 = self.minimumTotalHelper(triangle, i + 1, j)
        down2 = self.minimumTotalHelper(triangle, i + 1, j + 1)
        if down1 <= down2:
            self.dp[i][j] += down1
        else:
            self.dp[i][j] += down2
        return self.dp[i][j]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
print(s.minimumTotal(triangle))
