package leet_code;

import leet_code.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by sanyinchen on 19-10-7.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-7
 */

class Count_univalue_subtrees_250 {
    static class Solution {
        int number = 0;

        private boolean bfs(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean left = bfs(root.left);
            boolean right = bfs(root.right);
            boolean cur = true;
            TreeNode leftNext = root.left;
            TreeNode rightNext = root.right;
            if (leftNext != null && leftNext.val != root.val) {
                cur = false;
            }
            if (rightNext != null && rightNext.val != root.val) {
                cur = false;
            }
            cur = cur && right && left;
            if (cur) {
                number++;
            }

            return cur;
        }

        public int countUnivalSubtrees(TreeNode root) {
            number = 0;
            bfs(root);
            return number;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        new Solution().countUnivalSubtrees(root);
    }
}
