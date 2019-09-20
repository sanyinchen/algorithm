package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Same_Tree_100 {
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null) {
                return false;
            }
            if (q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
