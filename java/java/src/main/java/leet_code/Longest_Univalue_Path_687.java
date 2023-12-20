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

        private int treeScan(TreeNode root, int preValue) {
            if (root == null) {
                return 0;
            }
            int tempMax = 0;
            int left = treeScan(root.left, root.val);
            int right = treeScan(root.right, root.val);
            if (root.left != null && root.val == root.left.val) {
                left++;
            } else {
                left = 0;
            }
            if (root.right != null && root.val == root.right.val) {
                right++;
            } else {
                right = 0;
            }

            tempMax = Math.max(left, right);
            if (root.right != null && root.left != null) {
                if (root.right.val == root.val && root.val == root.left.val) {
                    tempMax = left + right;

                }
            }

            max = Math.max(max, tempMax);
            return Math.max(left, right);
        }

        public int longestUnivaluePath(TreeNode root) {

            if (root == null || (root.right == null && root.left == null)) {
                return 0;
            }
            max = 0;

            treeScan(root, root.val);
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
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right.right = new TreeNode(1);
        treeNode.right.right.left = new TreeNode(1);
        treeNode.right.right.right = new TreeNode(1);


        //treeNode.right = new TreeNode(1);

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createMockTree();
        Solution solution = new Solution();
        System.out.println("res=>" + solution.longestUnivaluePath(treeNode));
    }
}
