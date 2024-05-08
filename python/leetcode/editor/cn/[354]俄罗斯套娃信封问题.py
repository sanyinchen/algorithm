# 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
# 
#  当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
# 
#  请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
# 
#  注意：不允许旋转信封。 
# 
#  示例 1： 
# 
#  
# 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
# 输出：3
# 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
# 
#  示例 2： 
# 
#  
# 输入：envelopes = [[1,1],[1,1],[1,1]]
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= envelopes.length <= 10⁵ 
#  envelopes[i].length == 2 
#  1 <= wi, hi <= 10⁵ 
#  
# 
#  Related Topics 数组 二分查找 动态规划 排序 👍 1009 👎 0
from functools import cmp_to_key, lru_cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        nums = sorted(envelopes, key=lambda x: x[0] * x[1])
        # print(nums)
        dp = [-1] * len(nums)

        def find(l: int, r: int, val: int) -> int:
            if l < r:
                return -1
            if l < 0 or r >= len(nums):
                return -1
            if val > nums[r][0] * nums[r][1]:
                return -1
            if val < [l][0] * nums[l][1]:
                return -1
            mid = (l + r) // 2
            left = find(l, mid, val)
            right = find(mid + 1, r, val)
            return -1

        def dfs(end: int) -> int:
            if dp[end] != -1:
                return dp[end]
            max_v = 1
            for i in range(end):
                if nums[i][0] < nums[end][0] and nums[i][1] < nums[end][1]:
                    cur = dfs(i) + 1
                    if max_v < cur:
                        max_v = cur
            dp[end] = max_v
            return dp[end]

        max_v = 1
        for i in range(len(nums)):
            max_v = max(dfs(i), max_v)
        return max_v


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
print(s.maxEnvelopes(envelopes))
