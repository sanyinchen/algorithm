package leet_code;

import java.util.ArrayList;
import java.util.List;


public class Binary_Tree_Inorder_Traversal_94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private void treeMidScan(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            treeMidScan(root.left, res);
            res.add(root.val);
            treeMidScan(root.right, res);

        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            treeMidScan(root, res);
            return res;
        }
    }


    static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = createTree();
        Solution solution = new Solution();
        solution.inorderTraversal(treeNode).forEach((item) -> {
            System.out.println(item);
        });
    }
}
