package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;

import javax.print.attribute.standard.NumberUp;

import leet_code.common.TreeNode;

/**
 * from https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 */
public class All_possible_full_binary_trees_894 {

    static class Solution {
        private List<TreeNode> list = new ArrayList<>();
        private int i = 0;
        private TreeNode mRoot;
        private TreeNode mcopy;
        private int mSkip = 0;

        private void copyTreeNode(TreeNode root, TreeNode copy) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                copy.left = new TreeNode(root.left.val);
            }
            if (root.right != null) {
                copy.right = new TreeNode(root.right.val);
            }
            copyTreeNode(root.left, copy.left);
            copyTreeNode(root.right, copy.right);
        }

        private void recoard() {
            if (mRoot == null) {
                return;
            }
            mcopy = new TreeNode(mRoot.val);
            copyTreeNode(mRoot, mcopy);
            list.add(mcopy);
        }

        public void scanAllPossibleFBT(TreeNode root, int max) {
            if (max == 0) {
                mSkip++;
                if (mSkip % 2 == 0) {
                    return;
                }
                recoard();
                return;
            }
            root.left = new TreeNode(++i);
            root.right = new TreeNode(++i);
            scanAllPossibleFBT(root.left, max - 1);
            scanAllPossibleFBT(root.right, max - 1);
            root.left = null;
            root.right = null;
            // i -= 2;
        }

        public void createSpPossibleFBT(TreeNode root, int max) {
            if (max == 0) {
                System.out.println("=======>");
                mSkip++;
                if (mSkip % 2 == 0) {
                    return;
                }
                // recoard();
                return;
            }

            scanAllPossibleFBT(root.left, max - 1);
            root.left = new TreeNode(++i);
            root.right = new TreeNode(++i);
            scanAllPossibleFBT(root.right, max - 1);

            // i -= 2;
        }

        public List<TreeNode> allPossibleFBT(int N) {
            list.clear();
            int maxSubTree = (N - 1) / 2;
            TreeNode root = new TreeNode(0);
            mRoot = root;
            scanAllPossibleFBT(root, maxSubTree);
            // scanAllPossibleFBT(root.left, maxSubTree);
            root = new TreeNode(0);
            mRoot = root;
            i = 0;

          //  maxSubTree--;
            while (maxSubTree > 0) {
                root.left = new TreeNode(++i);
                root.right = new TreeNode(++i);
                root=root.left;
                
            }
           // createSpPossibleFBT(root, maxSubTree - 1);


            System.out.println("===>" + list.size());
            return null;
        }
    }

    public static void main(String[] args) {
        new Solution().allPossibleFBT(7);
    }
}
