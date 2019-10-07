package leet_code;

import leet_code.common.TreeNode;

public class Kth_smallest_element_in_a_bst_230 {
    class Solution {
        int mIndex;
        int mValue;

        private void kthSmallestHeler(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            kthSmallestHeler(root.left, k);
            mIndex++;
            if (k == mIndex) {
                mValue = root.val;
                System.out.println("==>" + root.val + " tem:" + mIndex);
                return;
            }
            kthSmallestHeler(root.right, k);
            //tem++;
        }

        public int kthSmallest(TreeNode root, int k) {
            mIndex = 0;
            kthSmallestHeler(root, k);
            return mValue;
        }
    }
}
