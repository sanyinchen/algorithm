# 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
# 返回这颗 二叉树 。 
# 
#  
# 
#  示例 1: 
#  
#  
# 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
# 输出：[3,9,20,null,null,15,7]
#  
# 
#  示例 2: 
# 
#  
# 输入：inorder = [-1], postorder = [-1]
# 输出：[-1]
#  
# 
#  
# 
#  提示: 
# 
#  
#  1 <= inorder.length <= 3000 
#  postorder.length == inorder.length 
#  -3000 <= inorder[i], postorder[i] <= 3000 
#  inorder 和 postorder 都由 不同 的值组成 
#  postorder 中每一个值都在 inorder 中 
#  inorder 保证是树的中序遍历 
#  postorder 保证是树的后序遍历 
#  
# 
#  Related Topics 树 数组 哈希表 分治 二叉树 👍 1168 👎 0

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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        return self.build_tree_helper(inorder, postorder)

    def get_index_by_value(self, list: List[int], val: int) -> int:
        for i in range(len(list)):
            if val == list[i]:
                return i
        return -1

    def build_tree_helper(self, inorder: List[int], postorder: List[int]) -> \
            Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        if inorder is None:
            return None
        if len(inorder) == 0:
            return None
        root_val = postorder.pop()
        root_node = TreeNode(root_val)
        index = self.get_index_by_value(inorder, root_val)
        # print(root_index, index, root_val)
        left_list = inorder[:index]
        right_list = inorder[index + 1:]
        #print('root', left_list, root_node.val, right_list)
        right = self.build_tree_helper(right_list, postorder)
        left = self.build_tree_helper(left_list, postorder)

        # if leftRoot is not None:
        #     print('leftRoot', leftRoot.val, end="")
        # else:
        #     print('leftRoot #', end="")
        #
        # if rightRoot is not None:
        #     print(' right', rightRoot.val, end=" ")
        # else:
        #     print(' right #', end="")
        #
        # if root_node is not None:
        #     print(' root_node', root_node.val, end=" ")
        # else:
        #     print(' root_node #', end=" ")
        # print()

        # if rightRoot is not None:
        #     print('right', rightRoot.val, root_val)
        # if leftRoot is not None and rightRoot is not None:
        #     print('leftRoot', leftRoot.val, 'rightRoot', rightRoot.val, 'val', root_node.val)
        # if leftRoot is not None and rightRoot is None:
        #     print('leftRoot', leftRoot.val, 'rightRoot #', 'val', root_node.val)
        # if leftRoot is None and rightRoot is not None:
        #     print('leftRoot #', 'rightRoot', rightRoot.val, 'val', root_node.val)

        root_node.left = left
        root_node.right = right

        return root_node


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
# root = s.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7])
root = s.buildTree([9, 3, 15, 20, 7], [9, 15, 7, 20, 3])
binary_tree.print_level_order(root)
