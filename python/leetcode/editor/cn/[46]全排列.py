# 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [1,2,3]
# 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [0,1]
# 输出：[[0,1],[1,0]]
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [1]
# 输出：[[1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 6 
#  -10 <= nums[i] <= 10 
#  nums 中的所有整数 互不相同 
#  
# 
#  Related Topics 数组 回溯 👍 2797 👎 0


from typing import List


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def __init__(self):
        self.permutes = []

    def permute(self, nums: List[int]) -> List[List[int]]:
        self.permute_extra([], nums)
        return self.permutes

    def permute_extra(self, nums_res: List[int], nums: List[int]):

        if len(nums) == 0:
            self.permutes.append(nums_res.copy())
            return
        for num in nums:
            nums_res.append(num)
            left = list(set(nums) - set(nums_res))
            self.permute_extra(nums_res, left)
            nums_res.remove(num)


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.permute([1, 2, 3]))
