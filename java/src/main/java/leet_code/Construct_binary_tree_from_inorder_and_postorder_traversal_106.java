package leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import leet_code.common.TreeNode;

public class Construct_binary_tree_from_inorder_and_postorder_traversal_106 {
    class Solution {
        int i = 0;

        private TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder, int l, int r) {
            if (l > r || i < 0) {
                return null;
            }
            int rootValue = preorder[i--];
            TreeNode root = new TreeNode(rootValue);
            int mid = map.get(rootValue);
            TreeNode right = buildTreeHelper(map, preorder, mid + 1, r);
            TreeNode left = buildTreeHelper(map, preorder, l, mid - 1);
            root.left = left;
            root.right = right;
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            i = map.size();
            return buildTreeHelper(map, postorder, 0, postorder.length - 1);
        }
    }

    public static void main(String[] args) {
        Map<String,Integer> map=new ConcurrentHashMap<>();
        System.out.println(map.get("123"));
    }
}
