package leet_code

import leet_code.common.TreeNode

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */
class KT_Sum_of_left_leaves_404 {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var sum = 0
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.`val`
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + sum
    }
}