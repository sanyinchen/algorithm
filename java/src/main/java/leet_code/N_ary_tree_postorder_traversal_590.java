package leet_code;

import java.util.ArrayList;
import java.util.List;

import leet_code.common.Node;

/**
 * Created by sanyinchen on 19-10-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-9
 */

class N_ary_tree_postorder_traversal_590 {
    class Solution {
        private void postorderHelper(Node root, List<Integer> collect) {
            if (root == null) {
                return;
            }
            for (Node child : root.children) {
                postorderHelper(child, collect);
            }
            collect.add(root.val);
        }

        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            postorderHelper(root, res);
            return res;
        }
    }
}
