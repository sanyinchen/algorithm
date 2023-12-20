package leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-15
 */

class Range_sum_of_bst_938 {
    static class Solution {

        private void treeScan(TreeNode root, List<TreeNode> allNodes) {
            if (root == null) {
                return;
            }

            treeScan(root.left, allNodes);
            allNodes.add(root);
            treeScan(root.right, allNodes);

        }

        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            List<TreeNode> allNodes = new ArrayList<>();

            treeScan(root, allNodes);

            int sum = Integer.MAX_VALUE;
            for (TreeNode item : allNodes) {
                if (item.val == R) {
                    if (sum == Integer.MAX_VALUE) {
                        sum = item.val;
                    } else {
                        sum += item.val;
                    }
                    break;
                }
                if (item.val == L) {
                    sum = item.val;
                    continue;
                }
                if (sum != Integer.MAX_VALUE) {
                    sum += item.val;
                }
            }
            return sum ;
        }

    }

    public static TreeNode createMockTree() {
//        TreeNode treeNode = new TreeNode(5);
//        treeNode.left = new TreeNode(4);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(1);
//
//        treeNode.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(5);

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(4);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
//
//        treeNode.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(5);

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(3);

        return treeNode;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = createMockTree();
//        Solution solution = new Solution();
//        System.out.println("res=>" + solution.maxPathSum(treeNode));
    }
}
