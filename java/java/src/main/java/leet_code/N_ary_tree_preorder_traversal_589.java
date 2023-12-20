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

class N_ary_tree_preorder_traversal_589 {
    class Solution {
        private void preorderHelper(Node root, List<Integer> collect) {
            if (root == null) {
                return;
            }
            collect.add(root.val);
            for (Node child : root.children) {
                preorderHelper(child, collect);
            }
        }

        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            preorderHelper(root, res);
            return res;
        }
    }
}
