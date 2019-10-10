package leet_code;

import java.util.ArrayList;
import java.util.List;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-9
 */

class Binary_tree_preorder_traversal_144 {
    class Solution {
        private void preorderTraversal(TreeNode root, List<Integer> collect) {
            if (root == null) {
                return;
            }
            collect.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal(root, res);
            return res;
        }
    }
}
