package leet_code_part2;

import leet_code.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Zhong_jian_er_cha_shu_lcof_07 {
    static class Solution {
        int i = 0;

        private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> inOrderMap, int l, int r) {
            if (l > r || i >= preorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i++]);
            if (i >= preorder.length) {
                return root;
            }
            int mid = inOrderMap.get(root.val);
            root.left = buildTreeHelper(preorder, inOrderMap, l, mid - 1);
            root.right = buildTreeHelper(preorder, inOrderMap, mid + 1, r);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> midMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                midMap.put(inorder[i], i);
            }
            return buildTreeHelper(preorder, midMap, 0, inorder.length - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode.val);

    }
}
