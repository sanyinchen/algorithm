package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-7.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-7
 */

class Subtree_of_another_tree_572 {
    class Solution {
        private boolean subbed = false;

        private boolean isTheSame(TreeNode tree1, TreeNode tree2) {
            if (tree1 == null && tree2 == null) {
                return true;
            }

            if (tree1 == null) {
                return false;
            }
            if (tree2 == null) {
                return false;
            }
            if (tree1.val != tree2.val) {
                return false;
            }

            return isTheSame(tree1.left, tree2.left) && isTheSame(tree1.right, tree2.right);
        }

        private void bfs(TreeNode root, TreeNode subTreeRoot) {
            if (root == null) {
                return;
            }
            bfs(root.left, subTreeRoot);
            bfs(root.right, subTreeRoot);
            if (isTheSame(root, subTreeRoot)) {
                subbed = true;
                return;
            }
        }

        public boolean isSubtree(TreeNode s, TreeNode t) {
            subbed = false;
            bfs(s, t);
            return subbed;
        }
    }
}
