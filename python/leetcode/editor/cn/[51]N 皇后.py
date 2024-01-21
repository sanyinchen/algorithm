# 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
# 
#  n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
# 
#  给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
# 
#  
#  
#  每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
#  
#  
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：n = 4
# 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
# 解释：如上图所示，4 皇后问题存在两个不同的解法。
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：[["Q"]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 9 
#  
# 
#  Related Topics 数组 回溯 👍 2009 👎 0

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def __init__(self):
        self.queens = []
        self.res: List[List[str]] = []

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.queens = []
        self.solve_nQueens_extra(0, n, [])
        return self.queens

    def queue_print(self, res: List[List[str]]):
        i_len = len(res)
        copy_res = []
        for i in range(i_len):
            # print(res[i])
            copy_res.append(''.join(res[i]))
        self.queens.append(copy_res)
        # print("=============================")

    def solve_nQueens_extra(self, x: int, n: int, check_point: List):
        if x >= n:
            return
        for x_i in range(x, n):
            item = ['.'] * n
            for j in range(n):
                item[j] = 'Q'
                check_point.append([x_i, j])
                self.res.append(item)
                if self.check(x, j, self.res) is False:
                    check_point.pop()
                    self.res.pop()
                    item[j] = '.'
                    continue
                self.solve_nQueens_extra(x_i + 1, n, check_point)
                if len(self.res) == n:
                    valid = True
                    for check_point_item in check_point:
                        if self.check(check_point_item[0], check_point_item[1], self.res) is False:
                            valid = False
                    if valid:
                        self.queue_print(self.res)
                check_point.pop()
                self.res.pop()
                item[j] = '.'

    def check(self, i: int, j: int, res: List[List[str]]) -> bool:
        if i >= len(res):
            return False
        # print('check', i, j, res)
        return self.check_detail_x(i - 1, j, res) and self.check_detail_y(i, j - 1, res) \
               and self.check_detail_x_y(i - 1, j - 1, res) and self.check_detail_y_x(i - 1, j + 1, res)

    def check_detail_x(self, i: int, j: int, res: List[List[str]]) -> bool:
        if i < 0 or j < 0:
            return True
        if res[i][j] == 'Q':
            return False
        if self.check_detail_x(i - 1, j, res) is False:
            return False
        return True

    def check_detail_y(self, i: int, j: int, res: List[List[str]]) -> bool:

        if i < 0 or j < 0:
            return True
        if res[i][j] == 'Q':
            return False
        if self.check_detail_y(i, j - 1, res) is False:
            return False
        return True

    def check_detail_x_y(self, i: int, j: int, res: List[List[str]]) -> bool:
        if i < 0 or j < 0:
            return True
        if res[i][j] == 'Q':
            return False
        if self.check_detail_x_y(i - 1, j - 1, res) is False:
            return False
        return True

    def check_detail_y_x(self, i: int, j: int, res: List[List[str]]) -> bool:
        if j >= len(res[0]):
            return True
        if i < 0 or j < 0:
            return True
        if res[i][j] == 'Q':
            return False
        if self.check_detail_y_x(i - 1, j + 1, res) is False:
            return False
        return True


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.solveNQueens(8))
# list = [['.', '.', 'Q', '.'],
#         ['Q', '.', '.', '.'],
#         ['.', '.', '.', 'Q'],
#         ['.', 'Q', '.', '.']]
# print(s.check_detail_y_x(3, 0, list))
