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
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode leftNode = sortedArrayToBST(nums, left, mid - 1);
        TreeNode rightNode = sortedArrayToBST(nums, mid + 1, right);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = leftNode;
        node.right = rightNode;
        return node;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}
