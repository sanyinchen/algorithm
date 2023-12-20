package leet_code;

import java.util.LinkedList;
import java.util.Queue;

import leet_code.common.TreeNode;

public class Maximum_level_sum_of_a_binary_tree_1161 {
    class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            Pair max = new Pair(-1, Integer.MIN_VALUE);
            int i = 0;
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                i++;
                sum = 0;
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (left != null) {
                        queue.add(left);
                    }
                    if (right != null) {
                        queue.add(right);
                    }
                }
                if (max.value < sum) {
                    max = new Pair(i, sum);
                }
            }
            return max.index;
        }

        private class Pair {
            int index;
            int value;

            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }
}
