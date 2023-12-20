package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-18.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Maximum_depth_of_binary_tree_104 {


    private int maxDepthHelper(TreeNode root, int dep) {
        if (root == null) {
            return dep;
        }
        int left = maxDepthHelper(root.left, dep + 1);
        int right = maxDepthHelper(root.right, dep + 1);
        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    public int maxDepth(TreeNode root) {

        return maxDepthHelper(root, 0);

    }
}
