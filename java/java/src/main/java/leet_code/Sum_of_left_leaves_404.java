package leet_code;

import java.util.Set;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class Sum_of_left_leaves_404 {
    static class Solution {


        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum = root.left.val;
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + sum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}
