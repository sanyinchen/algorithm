package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-15
 */

class Binary_tree_maximum_path_sum_124 {
    static class Solution {
        private int max = Integer.MIN_VALUE;

        private int treeScan(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = treeScan(root.left);
            int right = treeScan(root.right);
            int tempMax = root.val;
            if (root.left != null) {
                left += root.val;
            } else {
                left = root.val;
            }

            if (root.right != null) {
                right += root.val;
            } else {
                right = root.val;
            }

            if (root.right != null && root.left != null) {
                tempMax = left + right - root.val;
            }
            tempMax = Math.max(Math.max(Math.max(right, left), tempMax), root.val);
            max = Math.max(max, tempMax);
            return Math.max(Math.max(left, right),root.val);
        }

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            max = Integer.MIN_VALUE;
            treeScan(root);
            return max;
        }
    }

    public static TreeNode createMockTree() {
//        TreeNode treeNode = new TreeNode(5);
//        treeNode.left = new TreeNode(4);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(1);
//
//        treeNode.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(5);

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(4);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
//
//        treeNode.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(5);

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(3);

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createMockTree();
        Solution solution = new Solution();
        System.out.println("res=>" + solution.maxPathSum(treeNode));
    }
}
