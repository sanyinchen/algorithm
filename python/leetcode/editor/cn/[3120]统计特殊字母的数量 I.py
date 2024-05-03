# 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。 
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
#  word 中的特殊字母是 'a'、'b' 和 'c'。 
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
#  word 中不存在大小写形式同时出现的字母。 
# 
#  示例 3: 
# 
#  
#  输入：word = "abBCab" 
#  
# 
#  输出：1 
# 
#  解释： 
# 
#  word 中唯一的特殊字母是 'b'。 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= word.length <= 50 
#  word 仅由小写和大写英文字母组成。 
#  
# 
#  Related Topics 哈希表 字符串 👍 1 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        key_set = set()
        memo = []
        sum = 0
        for item in word:
            key_set.add(ord(item))
        for key in key_set:
            if (key + 32) in key_set:
                sum += 1
        return sum


# leetcode submit region end(Prohibit modification and deletion)
print(ord('a'), ord('A'))
s = Solution()
print(s.numberOfSpecialChars('aaAbcBC'))
