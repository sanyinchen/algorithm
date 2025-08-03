//给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: preorder = [5,2,1,3,6]
//输出: true 
//
// 示例 2： 
//
// 
//输入: preorder = [5,2,6,1,3]
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 10⁴ 
// 1 <= preorder[i] <= 10⁴ 
// preorder 中 无重复元素 
// 
//
// 
//
// 进阶：您能否使用恒定的空间复杂度来完成此题？ 
//
// Related Topics 栈 树 二叉搜索树 递归 数组 二叉树 单调栈 👍 212 👎 0

# include<common.h>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool verifyPreorder(vector<int>& preorder) {
        function<bool(int, int)> is_verify_preorder = [&](int start, int end) {
            if (start >= end) return true; // 空区间或单个元素肯定是 BST 先序遍历

            int root = preorder[start];
            int rightStart = start + 1;

            // 找到第一个大于 root 的元素，划分左/右子树
            while (rightStart <= end && preorder[rightStart] < root) {
                rightStart++;
            }

            // 检查右子树所有元素是否都大于 root
            for (int i = rightStart; i <= end; ++i) {
                if (preorder[i] < root) return false;
            }

            // 递归判断左子树和右子树
            return is_verify_preorder(start + 1, rightStart - 1) &&
                is_verify_preorder(rightStart, end);
        };
        return is_verify_preorder(0, preorder.size() - 1);
    }
};

//leetcode submit region end(Prohibit modification and deletion)
