package leet_code;

import java.util.HashMap;
import java.util.Map;

import leet_code.common.TreeNode;

public class Construct_binary_tree_from_preorder_and_inorder_traversal_105 {
    class Solution {
        int i = 0;

        private TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder, int l, int r) {
            if (l > r || i == map.size()) {
                return null;
            }
            int rootValue = preorder[i++];
            TreeNode root = new TreeNode(rootValue);
            int mid = map.get(rootValue);
            root.left = buildTreeHelper(map, preorder, l, mid - 1);
            root.right = buildTreeHelper(map, preorder, mid + 1, r);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            i = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTreeHelper(map, preorder, 0, preorder.length - 1);
        }
    }
}
