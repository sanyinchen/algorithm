# 给你一个大小为 m x n 的二维矩形 grid 。每次 操作 中，你可以将 任一 格子的值修改为 任意 非负整数。完成所有操作后，你需要确保每个格子 
# grid[i][j] 的值满足： 
# 
#  
#  如果下面相邻格子存在的话，它们的值相等，也就是 grid[i][j] == grid[i + 1][j]（如果存在）。 
#  如果右边相邻格子存在的话，它们的值不相等，也就是 grid[i][j] != grid[i][j + 1]（如果存在）。 
#  
# 
#  请你返回需要的 最少 操作数目。 
# 
#  
# 
#  示例 1： 
# 
#  
#  输入：grid = [[1,0,2],[1,0,2]] 
#  
# 
#  输出：0 
# 
#  解释： 
# 
#  
# 
#  矩阵中所有格子已经满足要求。 
# 
#  示例 2： 
# 
#  
#  输入：grid = [[1,1,1],[0,0,0]] 
#  
# 
#  输出：3 
# 
#  解释： 
# 
#  
# 
#  将矩阵变成 [[1,0,1],[1,0,1]] ，它满足所有要求，需要 3 次操作： 
# 
#  
#  将 grid[1][0] 变为 1 。 
#  将 grid[0][1] 变为 0 。 
#  将 grid[1][2] 变为 1 。 
#  
# 
#  示例 3： 
# 
#  
#  输入：grid = [[1],[2],[3]] 
#  
# 
#  输出：2 
# 
#  解释： 
# 
#  
# 
#  这个矩阵只有一列，我们可以通过 2 次操作将所有格子里的值变为 1 。 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n, m <= 1000 
#  0 <= grid[i][j] <= 9 
#  
# 
#  Related Topics 数组 动态规划 矩阵 👍 8 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def __init__(self):
        self.min = sys.maxsize
        self.list = []

    def minimumOperations(self, grid: List[List[int]]) -> int:
        grid_list = []
        num_cols = len(grid[0])  # 获取二维数组的列数

        for col in range(num_cols):  # 遍历每一列
            column_values = {}
            for row in grid:  # 遍历每一行
                if row[col] in column_values:
                    column_values[row[col]] += 1
                else:
                    column_values[row[col]] = 1
            grid_list.append(column_values)
        self.dp = [-1 for _ in range(len(grid_list))]
        print(grid_list)
        return self.minimumOperationsHelper(grid_list, -1, 0)

    def get_value(self, compare, map):
        res = 0
        for key, value in map.items():
            if key != compare:
                res += value
        return res

    def minimumOperationsHelper(self, grid: List, pre_value: int, index: int) -> int:
        if index >= len(grid):
            return 0

        # if self.dp[index] != -1:
        #     return self.dp[index]

        res = 0
        for i in range(index, len(grid)):
            if self.dp[i] != -1:
                continue
            values = grid[i]
            cur_min = sys.maxsize
            temp = []
            find = False
            for item in range(9):
                if item != pre_value:
                    find = True
                    opt_times = self.get_value(item, values)
                    self.list.append(item)
                    print(self.list)
                    temp = self.list.copy()
                    cur_min = min(self.minimumOperationsHelper(grid, item, i + 1) + opt_times, cur_min)
                    print('i', i, 'cur_min', cur_min)
                    print('get', 'i', i, self.list)
                    self.list.pop()
                else:
                    print('skip', 'i', i, self.list, item)
            res += cur_min
            print('i', i, 'cur_min', cur_min, 'res', res, temp)
            self.dp[i] = res

        print(index, 'res', res)
        return self.dp[index]

    # leetcode submit region end(Prohibit modification and deletion)


grid = [[1, 1, 1], [0, 0, 0]]
# grid = [[4, 6], [4, 8]]
grid = [[2, 6, 6, 9, 8, 4, 2, 6, 2, 3]]
grid = [[1, 0, 2], [1, 0, 2]]
s = Solution()
print(s.minimumOperations(grid))
