package leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet_code.common.Node;

/**
 * Created by sanyinchen on 19-10-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-9
 */

class n_ary_tree_level_order_traversal_429 {
    class Solution {

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> collect = new ArrayList<>();
            if (root == null) {
                return collect;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            List<Integer> level = new ArrayList<>();
            level.add(root.val);
            collect.add(level);
            while (!queue.isEmpty()) {
                int count = queue.size();
                level = new ArrayList<>();
                while (count-- > 0) {
                    Node child = queue.poll();
                    level.add(child.val);
                    for (Node item : child.children) {
                        queue.add(item);
                    }
                }
                if (level.size() != 0) {
                    collect.add(level);
                }
            }
            return collect;
        }
    }
}
