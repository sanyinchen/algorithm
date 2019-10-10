package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 19-10-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-9
 */

class House_robber_iii_337 {
    static class Solution {
        Map<TreeNode, Integer> marked = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (marked.containsKey(root)) {
                return marked.get(root);

            }
            int max = Math.max(rob(root.left) + rob(root.right),
                    root.val
                            + rob(root.left != null ? root.left.left : null)
                            + rob(root.left != null ? root.left.right : null)
                            + rob(root.right != null ? root.right.left : null)
                            + rob(root.right != null ? root.right.right : null));
            marked.put(root, max);
            return max;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);


        System.out.println("res：" + new Solution().rob(root));
    }
}
