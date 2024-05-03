# 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称
# 字母 c 是一个 特殊字母 。 
# 
#  返回 word 中 特殊字母 的数量。 
# 
#  
# 
#  示例 1: 
# 
#  
#  输入：word = "aaAbcBC" 
#  
# 
#  输出：3 
# 
#  解释： 
# 
#  特殊字母是 'a'、'b' 和 'c'。 
# 
#  示例 2: 
# 
#  
#  输入：word = "abc" 
#  
# 
#  输出：0 
# 
#  解释： 
# 
#  word 中不存在特殊字母。 
# 
#  示例 3: 
# 
#  
#  输入：word = "AbBCab" 
#  
# 
#  输出：0 
# 
#  解释： 
# 
#  word 中不存在特殊字母。 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= word.length <= 2 * 10⁵ 
#  word 仅由小写和大写英文字母组成。 
#  
# 
#  Related Topics 哈希表 字符串 👍 5 👎 0
from builtins import str


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        res = 0
        key_map = {}
        for i in range(len(word)):
            ord_value = ord(word[i])
            if ord_value in key_map and ord_value <= 90:
                continue
            key_map[ord_value] = i
        for key, value in key_map.items():
            find_key = key - 32
            if find_key in key_map:
                find_value = key_map[find_key]
                if find_value > value:
                    #print(find_value)
                    res += 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(ord('z'), ord('Z'))
s = Solution()
str = 'AbBCab'
str = 'aaAbcBC'
print(s.numberOfSpecialChars(str))
