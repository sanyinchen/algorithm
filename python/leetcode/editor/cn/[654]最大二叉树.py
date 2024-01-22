# 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
# 
#  
#  创建一个根节点，其值为 nums 中的最大值。 
#  递归地在最大值 左边 的 子数组前缀上 构建左子树。 
#  递归地在最大值 右边 的 子数组后缀上 构建右子树。 
#  
# 
#  返回 nums 构建的 最大二叉树 。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：nums = [3,2,1,6,0,5]
# 输出：[6,3,5,null,2,0,null,null,1]
# 解释：递归调用如下所示：
# - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
#     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
#         - 空数组，无子节点。
#         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
#             - 空数组，无子节点。
#             - 只有一个元素，所以子节点是一个值为 1 的节点。
#     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
#         - 只有一个元素，所以子节点是一个值为 0 的节点。
#         - 空数组，无子节点。
#  
# 
#  示例 2： 
#  
#  
# 输入：nums = [3,2,1]
# 输出：[3,null,2,null,1]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 1000 
#  0 <= nums[i] <= 1000 
#  nums 中的所有整数 互不相同 
#  
# 
#  Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 764 👎 0
from typing import List, Optional
from leetcode.editor.cn.binary_tree import TreeNode, print_level_order


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) == 0:
            return None
        max_index, leftList, rightList = self.slice_list_by_max(nums)
        if max_index == -1:
            return None
        root = TreeNode(nums[max_index])
        left = self.constructMaximumBinaryTree([] if leftList is None else leftList)
        right = self.constructMaximumBinaryTree([] if rightList is None else rightList)
        root.left = left
        root.right = right
        return root

    def get_max_value_index(self, nums: List[int]) -> int:
        index = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[index]:
                index = i
        return index

    def slice_list_by_max(self, nums: List[int]) -> (int, Optional[List[int]], Optional[List[int]]):
        if len(nums) == 0:
            return -1, None, None
        max_index = self.get_max_value_index(nums)
        if max_index == 0:
            return 0, None, nums[1:]
        if max_index == len(nums) - 1:
            return max_index, nums[:max_index], None
        return max_index, nums[0:max_index], nums[max_index + 1:]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print_level_order(s.constructMaximumBinaryTree([3, 2, 1, 6, 0, 5]))
