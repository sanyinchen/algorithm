package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;

import javax.print.attribute.standard.NumberUp;

import leet_code.common.TreeNode;

/**
 * from https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 */
public class All_possible_full_binary_trees_894 {

    public static Map<Integer, List<TreeNode>> cache = new HashMap();
    static class Solution {

        public List<TreeNode> allPossibleFBT(int N) {
            if (!cache.containsKey(N)) {
                List<TreeNode> ans = new LinkedList();
                if (N == 1) {
                    ans.add(new TreeNode(-1));
                } else if (N % 2 == 1) {
                    for (int x = 0; x < N; ++x) {
                        int y = N - 1 - x;
                        for (TreeNode left : allPossibleFBT(x))
                            for (TreeNode right : allPossibleFBT(y)) {
                                TreeNode bns = new TreeNode(0);
                                bns.left = left;
                                bns.right = right;
                                System.out.println("N:" + N);
                                ans.add(bns);
                            }
                    }
                }
                cache.put(N, ans);
            }

            return cache.get(N);
        }

    }

    public static void main(String[] args) {
        new Solution().allPossibleFBT(7);
        System.out.println();
    }


}
