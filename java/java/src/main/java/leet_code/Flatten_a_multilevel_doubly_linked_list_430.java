package leet_code;


/**
 * Created by sanyinchen on 20-1-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-20
 */

class Flatten_a_multilevel_doubly_linked_list_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    class Solution {
        private Node first;
        private Node header;

        private void scan(Node head) {
            while (head != null) {
                Node temp = new Node();
                temp.val = head.val;
                if (first == null) {
                    first = temp;
                    header = first;
                } else {
                    temp.next = null;
                    temp.prev = first;
                    first.next = temp;
                    first = temp;
                }

                Node child = head.child;
                if (child != null) {
                    scan(child);
                }
                head = head.next;
            }
        }

        public Node flatten(Node head) {
            scan(head);
            return header;
        }
    }
}
