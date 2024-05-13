# 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
# 
#  测试用例的答案是一个 32-位 整数。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: nums = [2,3,-2,4]
# 输出: 6
# 解释: 子数组 [2,3] 有最大乘积 6。
#  
# 
#  示例 2: 
# 
#  
# 输入: nums = [-2,0,-1]
# 输出: 0
# 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
# 
#  
# 
#  提示: 
# 
#  
#  1 <= nums.length <= 2 * 10⁴ 
#  -10 <= nums[i] <= 10 
#  nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
#  
# 
#  Related Topics 数组 动态规划 👍 2235 👎 0


# leetcode submit region begin(Prohibit modification and deletion)

import sys
from functools import lru_cache
from typing import List


class Solution:
    def __init__(self):
        self.dp = {}

    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        self.dp = {}

        max_v = nums[0]
        for i in range(len(nums)):
            cur_sum = nums[i]
            tmp = cur_sum
            max_v = max(max_v, tmp)
            for j in range(i + 1, len(nums)):
                tmp *= nums[j]
                max_v = max(max_v, tmp)
        return max_v


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
nums = [-2, 3, -4]
nums = [-2, 0, -1, -3, -3]
print(s.maxProduct(nums))
