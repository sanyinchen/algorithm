package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leet_code.common.ListNode;
import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-18.
 * <p>
 * from https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Unique_binary_search_trees_ii_95 {
    static class Solution {
        Map<String, List<TreeNode>> memo = new HashMap();

        private String getStrKey(int start, int end) {
            return start + "_" + end;
        }

        public List<TreeNode> generateTreesHelper(int start, int end) {
            if (!memo.containsKey(getStrKey(start, end))) {
                List<TreeNode> ans = new LinkedList();
                if (start > end) {
                    ans.add(null);
                    return ans;
                } else {
                    for (int i = start; i <= end; i++) {
                        List<TreeNode> lefts = generateTreesHelper(start, i - 1);
                        List<TreeNode> rights = generateTreesHelper(i + 1, end);
                        for (TreeNode left : lefts) {
                            for (TreeNode right : rights) {
                                TreeNode rootNode = new TreeNode(i);
                                rootNode.left = left;
                                rootNode.right = right;
                                ans.add(rootNode);
                            }
                        }

                    }
                }
                memo.put(getStrKey(start, end), ans);
            }

            return memo.get(getStrKey(start, end));
        }

        public List<TreeNode> generateTrees(int n) {
            if (n==0){
                return new LinkedList<>();
            }

            return generateTreesHelper(1, n);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> res = new Solution().generateTrees(1);
        System.out.println(res.size());
    }
}
