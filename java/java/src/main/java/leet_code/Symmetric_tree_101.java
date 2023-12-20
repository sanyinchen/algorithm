package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Symmetric_tree_101 {
    private boolean isSymmetric(TreeNode p, TreeNode q) {
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
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

}
