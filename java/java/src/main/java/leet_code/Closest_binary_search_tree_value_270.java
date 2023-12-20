package leet_code;

import leet_code.common.TreeNode;

public class Closest_binary_search_tree_value_270 {
    class Solution {
        private int res;
        private double dis;

        private void scan(TreeNode root, double target) {
            if (root == null) {
                return;
            }
            if (dis >= Math.abs(target - root.val)) {
                dis = Math.abs(target - root.val);
                res = root.val;
            }
            scan(root.left, target);
            scan(root.right, target);
        }

        public int closestValue(TreeNode root, double target) {
            res = root.val;
            dis = Math.abs(target - res);
            scan(root, target);
            return res;
        }
    }
}
