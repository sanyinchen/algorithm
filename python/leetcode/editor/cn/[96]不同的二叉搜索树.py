# 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：n = 3
# 输出：5
#  
# 
#  示例 2： 
# 
#  
# 输入：n = 1
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 19 
#  
# 
#  Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2504 👎 0
import functools


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numTrees(self, n: int) -> int:
        @functools.cache
        def catalan(n) -> int:
            # print(n)
            if n <= 1:
                return 1
            res = 0
            for x in range(n):
                res += catalan(x) * catalan(n - 1 - x)
            return res

        return catalan(n)
# leetcode submit region end(Prohibit modification and deletion)
