package leet_code;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 20-1-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-19
 */

class Odd_even_linked_list_328 {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode headA = head;
            if (headA == null || headA.next == null) {
                return head;
            }
            ListNode headB = head.next;
            ListNode tail = head.next;
            ListNode first = headA;
            while (true) {
                if (headA != null) {
                    headA.next = headA.next == null ? null : headA.next.next;
                    headA = headA.next;
                }

                if (headB != null) {
                    headB.next = headB.next == null ? null : headB.next.next;
                    headB = headB.next;
                }


                if (headA == null && headB == null) {
                    break;
                }

            }
            ListNode temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tail;
            return first;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode head = solution.oddEvenList(listNode1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
