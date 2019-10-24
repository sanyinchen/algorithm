package leet_code;

import java.util.HashMap;
import java.util.Map;

import leet_code.common.TreeNode;

public class Construct_binary_tree_from_inorder_and_postorder_traversal_106 {
    class Solution {
        int i = 0;

        private TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder, int l, int r, int iC) {
            if (l > r || i == map.size()) {
                return null;
            }
            int rootValue = preorder[i++];
            int mid = map.get(rootValue);
            TreeNode left = buildTreeHelper(map, preorder, l, mid - 1, i);
            TreeNode right = buildTreeHelper(map, preorder, mid + 1, r, i);
            TreeNode root = new TreeNode(preorder[iC]);
            root.left = left;
            root.right = right;
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            i = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTreeHelper(map, postorder, 0, postorder.length - 1,0);
        }
    }
}
