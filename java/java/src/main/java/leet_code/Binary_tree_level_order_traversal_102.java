package leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet_code.common.TreeNode;

public class Binary_tree_level_order_traversal_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> step = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode temp = queue.poll();
                    step.add(temp.val);
                    TreeNode left = temp.left;
                    TreeNode right = temp.right;
                    if (left != null) {
                        queue.add(left);
                    }
                    if (right != null) {
                        queue.add(right);
                    }
                }
                if (step.size() != 0) {
                    res.add(step);
                }
            }
            return res;
        }
    }
}
