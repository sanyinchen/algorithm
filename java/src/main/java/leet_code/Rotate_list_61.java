package leet_code;

import java.util.ArrayList;
import java.util.List;

import leet_code.common.ListNode;

public class Rotate_list_61 {
    static class Solution {

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            List<ListNode> nodes = new ArrayList<>();
            ListNode header = head;
            while (head != null) {
                nodes.add(head);
                head = head.next;
            }
            int size = nodes.size();
            k = k % size;
            if (k == 0) {
                return header;
            }
            ListNode[] arrays = nodes.toArray(new ListNode[0]);

            for (int i = 0; i < arrays.length; i++) {
                int targetIndex = (i - k + size) % size;
                System.out.println("target index:" + targetIndex + " " + nodes.get(targetIndex).val);
                arrays[i] = nodes.get(targetIndex);
            }

            ListNode resHeader = arrays[0];
            ListNode first = resHeader;
            for (int i = 1; i < arrays.length; i++) {
                resHeader.next = arrays[i];
                resHeader = arrays[i];
            }
            resHeader.next = null;
            return first;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode res = solution.rotateRight(listNode, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
