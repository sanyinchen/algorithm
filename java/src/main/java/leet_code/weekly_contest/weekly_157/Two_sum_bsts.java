package leet_code.weekly_contest.weekly_157;

import java.util.HashSet;
import java.util.Set;

import leet_code.common.TreeNode;

public class Two_sum_bsts {
    class Solution {

        private void scanTree(TreeNode root, Set<Integer> cache) {
            if (root == null) {
                return;
            }
            cache.add(root.val);
            scanTree(root.left, cache);
            scanTree(root.right, cache);
        }

        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            Set<Integer> cache1 = new HashSet<>();
            Set<Integer> cache2 = new HashSet<>();
            scanTree(root1, cache1);
            scanTree(root2, cache2);
            for (Integer item : cache1) {
                int guess = target - item;
                if (cache2.contains(guess)) {
                    return true;
                }
            }
            return false;
        }
    }
}
