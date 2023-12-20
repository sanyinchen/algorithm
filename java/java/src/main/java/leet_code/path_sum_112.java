package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class path_sum_112 {
    class Solution {

        private boolean hasPathSumHelper(TreeNode root, int sum) {
            if (root.left == null && root.right == null) {
                return (sum - root.val) == 0;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        }

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            return hasPathSumHelper(root, sum);
        }
    }
}
