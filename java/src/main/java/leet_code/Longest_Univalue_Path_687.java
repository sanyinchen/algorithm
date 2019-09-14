package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-14
 */

class Longest_Univalue_Path_687 {

    static class Solution {

        private int max = 0;
        private int dep = 0;

        private void treeScan(TreeNode root, int preValue) {
            if (root == null) {
                return;
            }
            // System.out.println("currentDep==>" + currentDep + " preValue:" + preValue);

            if (root.val == preValue) {
                dep++;
            } else {
                dep = 1;
            }

            System.out.println("dep==>" + dep + " v:" + root.val);

            if (max < dep) {
                max = dep;
            }

            treeScan(root.left, root.val);
            treeScan(root.right, root.val);
        }

        public int longestUnivaluePath(TreeNode root) {
            if (root == null || (root.right == null && root.left == null)) {
                return 0;
            }
            max = 0;
            dep = 0;
            treeScan(root, root.val);
            return max - 1;
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
        treeNode.left = new TreeNode(1);
        //treeNode.right = new TreeNode(1);

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createMockTree();
        Solution solution = new Solution();
        System.out.println("res=>" + solution.longestUnivaluePath(treeNode));
    }
}
