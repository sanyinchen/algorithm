package leet_code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanyinchen on 20-1-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-20
 */

class Copy_list_with_random_pointer_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        private int getIndex(Node head, Node temp) {
            Node tempHead = head;
            int i = 0;
            while (tempHead != null) {
                if (tempHead == temp) {
                    return i;
                }
                i++;
                tempHead = tempHead.next;
            }
            return 0;
        }

        public Node copyRandomList(Node head) {
            Node copyHeader = new Node(-1);
            Node oldHeader = new Node(-1);
            oldHeader.next = head;
            Node temp = head;
            Node cacheCopyHeader = copyHeader;
            List<Node> list = new ArrayList<>();
            while (temp != null) {
                Node node = new Node(temp.val);
                list.add(node);
                copyHeader.next = node;
                copyHeader = copyHeader.next;
                temp = temp.next;
            }
            temp = oldHeader.next;
            Node temp2 = cacheCopyHeader.next;
            while (temp != null) {
                System.out.println("temp:" + temp.val + " temp2:" + temp2.val);
                Node random = temp.random;
                if (random != null) {
                    int index = getIndex(oldHeader.next, random);
                    temp2.random = list.get(index);
                }
                temp = temp.next;
                temp2 = temp2.next;
            }
            return cacheCopyHeader.next;
        }
    }
}
