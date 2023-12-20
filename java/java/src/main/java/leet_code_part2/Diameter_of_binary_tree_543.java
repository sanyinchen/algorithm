package leet_code_part2;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 20-3-10.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-10
 */

class Diameter_of_binary_tree_543 {
    public static class Solution {

        int ans = 0;

        private int binaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = binaryTree(root.left);
            int r = binaryTree(root.right);
            ans = Math.max(ans, l + r + 1);
            return Math.max(l, r) + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            binaryTree(root);
            return ans - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(solution.diameterOfBinaryTree(treeNode));
    }
}
