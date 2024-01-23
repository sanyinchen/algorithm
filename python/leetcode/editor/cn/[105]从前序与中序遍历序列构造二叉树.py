# 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
# 返回其根节点。 
# 
#  
# 
#  示例 1: 
#  
#  
# 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
# 输出: [3,9,20,null,null,15,7]
#  
# 
#  示例 2: 
# 
#  
# 输入: preorder = [-1], inorder = [-1]
# 输出: [-1]
#  
# 
#  
# 
#  提示: 
# 
#  
#  1 <= preorder.length <= 3000 
#  inorder.length == preorder.length 
#  -3000 <= preorder[i], inorder[i] <= 3000 
#  preorder 和 inorder 均 无重复 元素 
#  inorder 均出现在 preorder 
#  preorder 保证 为二叉树的前序遍历序列 
#  inorder 保证 为二叉树的中序遍历序列 
#  
# 
#  Related Topics 树 数组 哈希表 分治 二叉树 👍 2185 👎 0
from typing import List, Optional, Dict

from leetcode.editor.cn import binary_tree
from leetcode.editor.cn.binary_tree import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.build_tree_helper(preorder, inorder)

    def get_index_by_value(self, list: List[int], val: int) -> int:
        for i in range(len(list)):
            if val == list[i]:
                return i
        return -1

    def build_tree_helper(self, preorder: List[int], inorder: List[int]) -> \
            Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        if inorder is None:
            return None
        if len(inorder) == 0:
            return None
        root_val = preorder.pop(0)
        root_node = TreeNode(root_val)
        index = self.get_index_by_value(inorder, root_val)
        # print(root_index, index, root_val)
        left_list = inorder[:index]
        right_list = inorder[index + 1:]

        left = self.build_tree_helper(preorder, left_list)
        right = self.build_tree_helper(preorder, right_list)
        root_node.left = left
        root_node.right = right

        return root_node


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
# root = s.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7])
root = s.buildTree([1, 2], [1, 2])
binary_tree.print_level_order(root)
