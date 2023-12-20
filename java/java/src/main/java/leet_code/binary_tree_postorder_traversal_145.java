package leet_code;

import java.util.ArrayList;
import java.util.List;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class binary_tree_postorder_traversal_145 {
    class Solution {
        private List<Integer> res = new ArrayList<>();

        private void postorderTraversalHelper(TreeNode root) {
            if (root == null) {
                return;
            }
            postorderTraversalHelper(root.left);
            postorderTraversalHelper(root.right);
            res.add(root.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            res.clear();
            postorderTraversalHelper(root);
            return res;
        }
    }
}
