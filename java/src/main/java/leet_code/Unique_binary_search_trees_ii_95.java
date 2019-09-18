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
        Map<Integer, List<TreeNode>> memo = new HashMap();

        //        private List<TreeNode> generateTreesHelper(int n) {
//
//        }
        private int i = 0;
        List<TreeNode> ans = new LinkedList();

        public TreeNode generateTreesHelper(int n) {
            System.out.println("get ===>n:" + n);

            // List<TreeNode> ans = new LinkedList();
            if (n == 1) {
                new TreeNode(n);
            } else {
                for (int x = 0; x < n; ++x) {
                    int y = n - 1 - x;
                    System.out.println("x:" + x + " y:" + y);
                    TreeNode left = generateTreesHelper(x);
                    TreeNode right = generateTreesHelper(y);
                    TreeNode rootNode = new TreeNode(n);
                    rootNode.left = left;
                    rootNode.right = right;
                    ans.add(rootNode);
                    System.out.println("=========>i" + (++i));
//                        for (TreeNode left : lefts) {
//                            System.out.println("==>n:" + n + " left:" + left.val + " right:null");
//                            TreeNode rootNode = new TreeNode(n);
//                            rootNode.left = left;
//                            rootNode.right = null;
//                            ans.add(rootNode);
//                            // System.out.println("rights:" + rights.size());
//                            List<TreeNode> rights = generateTrees(y);
//                            System.out.println("lefts:" + lefts.size());
//                            for (TreeNode right : rights) {
//                                System.out.println("==>n:" + n + " left:" + left.val + " right:" + right.val);
//                                TreeNode rootNode2 = new TreeNode(n);
//                                rootNode2.left = left;
//                                rootNode2.right = right;
//                                ans.add(rootNode2);
//
//                            }
//                        }

                }
            }

            return null;
        }

        public List<TreeNode> generateTrees(int n) {
//            generateTreesHelper(n);
//            return ans;
//        }
            System.out.println("get ===>n:" + n);
            if (!memo.containsKey(n)) {
                List<TreeNode> ans = new LinkedList();
                if (n == 1) {
                    ans.add(new TreeNode(n));
                } else {
                    for (int x = 0; x < n; ++x) {
                        int y = n - 1 - x;
                        //System.out.println("x:" + x + " y:" + y);
                        List<TreeNode> lefts = generateTrees(x);
                        List<TreeNode> rights = generateTrees(y);
                        System.out.println("lefts:" + lefts.size() + "rights:" + rights.size());
                        TreeNode left = new TreeNode(0);
                        TreeNode right = new TreeNode(0);
                        TreeNode root = new TreeNode(0);
                        if (lefts.size() != 0) {
                            root.left = left;
                        }
                        if (rights.size() != 0) {
                            root.right = right;
                        }
                        ans.add(root);
                        System.out.println("=========>i" + (++i));

//                        System.out.println("=========>i" + (++i));
//                        for (TreeNode left : lefts) {
//                            for (TreeNode right : rights) {
//                                System.out.println("==>n:" + n + " left:" + left.val + " right:" + right.val);
//                                TreeNode rootNode2 = new TreeNode(n);
//                                rootNode2.left = left;
//                                rootNode2.right = right;
//                                ans.add(rootNode2);
//                            }
//                        }

                    }
                }
                memo.put(n, ans);
            }

            return memo.get(n);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> res = new Solution().generateTrees(5);
        System.out.println(res.size());
    }
}
