# 给你一个整数数组 nums ，你可以对它进行一些操作。 
# 
#  每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
#  + 1 的元素。 
# 
#  开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [3,4,2]
# 输出：6
# 解释：
# 删除 4 获得 4 个点数，因此 3 也被删除。
# 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [2,2,3,3,3,4]
# 输出：9
# 解释：
# 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
# 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
# 总共获得 9 个点数。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 2 * 10⁴ 
#  1 <= nums[i] <= 10⁴ 
#  
# 
#  Related Topics 数组 哈希表 动态规划 👍 932 👎 0
from typing import List, Tuple


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.dp = []

    def deleteAndEarn(self, nums: List[int]) -> int:
        self.widget = {}

        nums.sort()
        for i in range(len(nums)):
            if nums[i] in self.widget:
                self.widget[nums[i]] += 1
            else:
                self.widget[nums[i]] = 1
        widget_nums = []
        for key, value in self.widget.items():
            widget_nums.append((key, value))
        print(widget_nums)
        res = 0
        self.dp = [-1 for _ in range(len(widget_nums))]
        for i in range(len(widget_nums)):
            res = max(res, self.deleteAndEarnHelper(widget_nums, i))
        print(self.dp)
        return res

    def deleteAndEarnHelper(self, widget_nums: List[Tuple[int, int]], index: int) -> int:
        if index >= len(widget_nums):
            return 0
        if self.dp[index] != -1:
            return self.dp[index]
        max_v = 0
        cur_value = widget_nums[index][0] * widget_nums[index][1]
        for i in range(index + 1, len(widget_nums)):
            if widget_nums[i][0] == widget_nums[index][0] + 1:
                continue
            else:
                max_v = max(max_v, self.deleteAndEarnHelper(widget_nums, i))
        self.dp[index] = max_v + cur_value

        return self.dp[index]


# leetcode submit region end(Prohibit modification and deletion)

s = Solution()
nums = [3, 4, 2]
nums = [4, 2, 2, 3, 3, 3]
# nums = [3, 1]
print(s.deleteAndEarn(nums))
