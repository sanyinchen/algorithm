package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-16.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-16
 */

class Validate_binary_search_tree_98 {
    static class Solution {

        private boolean bstHelper(TreeNode root, long low, long high) {
            if (root == null) {
                return true;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;


            if (low != Long.MIN_VALUE && root.val <= low) {
                return false;
            }
            if (high != Long.MIN_VALUE && root.val >= high) {
                return false;
            }
            if (!bstHelper(right, root.val, high)) {
                return false;
            }
            if (!bstHelper(left, low, root.val)) {
                return false;
            }

            return true;
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return bstHelper(root, Long.MIN_VALUE, Long.MIN_VALUE);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println("====>" + new Solution().isValidBST(treeNode));
    }
}
