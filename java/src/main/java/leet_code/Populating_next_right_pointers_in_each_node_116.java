package leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by sanyinchen on 19-10-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-26
 */

class Populating_next_right_pointers_in_each_node_116 {
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Node> tempList = new ArrayList<>();
                while (size-- > 0) {
                    Node node = queue.poll();
                    tempList.add(node);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (tempList.isEmpty()) {
                    continue;
                }
                tempList.get(tempList.size() - 1).next = null;
                for (int i = tempList.size() - 2; i >= 0; i--) {
                    tempList.get(i).next = tempList.get(i + 1);
                }

            }
            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
