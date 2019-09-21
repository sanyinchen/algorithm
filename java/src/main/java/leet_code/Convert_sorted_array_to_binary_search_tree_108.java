package leet_code;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-9-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Convert_sorted_array_to_binary_search_tree_108 {
    private void sortedArrayToBST(int[] nums, int left, int right, int rootIndex, TreeNode leftNode,
                                  TreeNode rightNode) {
        if (left >= rootIndex && right >= nums.length) {
            return;
        }
        if (leftNode != null && left < rootIndex) {
            leftNode.left = new TreeNode(nums[left]);
        } else if (leftNode != null) {
            leftNode.left = null;
            leftNode.left = null;

        }
        if (rightNode != null && right < nums.length) {
            rightNode.left = new TreeNode(nums[right]);
        } else if (rightNode != null) {
            rightNode.left = null;
            rightNode.right = null;
        }
        sortedArrayToBST(nums, left + 1, right + 1, rootIndex, leftNode.left, rightNode.left);
        sortedArrayToBST(nums, left + 1, right + 1, rootIndex, leftNode.right, rightNode.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        int rootI = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootI]);

        if (nums.length <= 2) {
            root.left = new TreeNode(nums[0]);
        } else {
            root.left = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[rootI + 1]);
            sortedArrayToBST(nums, 1, rootI + 2, rootI, root.left, root.right);
        }


        return root;
    }
}
