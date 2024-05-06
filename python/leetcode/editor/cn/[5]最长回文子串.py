# 给你一个字符串 s，找到 s 中最长的回文子串。 
# 
#  如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：s = "babad"
# 输出："bab"
# 解释："aba" 同样是符合题意的答案。
#  
# 
#  示例 2： 
# 
#  
# 输入：s = "cbbd"
# 输出："bb"
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= s.length <= 1000 
#  s 仅由数字和英文字母组成 
#  
# 
#  Related Topics 双指针 字符串 动态规划 👍 7193 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from functools import lru_cache


class Solution:
    def __int__(self):
        self.str_sets = {}

    def longestPalindrome(self, s: str) -> str:
        str_len = len(s)
        if str_len == 1:
            return s[0]
        max_len = 0
        max_start = 0
        dp = [[-1 for _ in range(len(s))] for _ in range(len(s))]

        def dfs(start: int, end: int):
            nonlocal max_start, max_len, dp
            if dp[start][end] != -1:
                return dp[start][end]

            if end <= start:
                return 1
            dp[start][end] = dfs(start + 1, end - 1) & (s[start] == s[end])
            return dp[start][end]

        for i in range(len(s)):
            for j in range(i, len(s)):
                if dfs(i, j) == 1:
                    if max_len < (j - i + 1):
                        max_len = j - i + 1
                        max_start = i

        # print(max_len, max_start, s[max_start:max_start + max_len])
        return s[max_start:max_start + max_len]


# leetcode submit region end(Prohibit modification and deletion)

so = Solution()
s = "babad"
s = "abb"
s = "ccccccccccccccccccccccccccccccccccccccccccccccc"
print(so.longestPalindrome(s))
