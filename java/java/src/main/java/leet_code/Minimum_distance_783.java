package leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leet_code.common.TreeNode;

/**
 * from https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class Minimum_distance_783 {

    public void minDiffInBST(TreeNode root, List<Integer> sum) {
        if (root == null) {
            return;
        }
        sum.add(root.val);
        minDiffInBST(root.left, sum);
        minDiffInBST(root.right, sum);

    }

    public int minDiffInBST(TreeNode root) {
        //Pair<Pair<Integer>> res = new Pair<>();
        List<Integer> sum = new ArrayList<>();
        minDiffInBST(root, sum);
        Collections.sort(sum, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (sum.size() == 1) {
            return sum.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = i + 1; j < sum.size(); i++, j++) {
            int dis = Math.abs(sum.get(i) - sum.get(j));
            if (min > dis) {
                min = dis;
            }
        }
        return min;
    }

}
