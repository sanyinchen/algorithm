package leet_code;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 19-9-18.
 *
 * from https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Merge_two_sorted_lists_21 {

    static class Solution {


        private void mergeTwoListsHelper(ListNode l1, ListNode l2, ListNode head) {

            if (l1 == null && l2 == null) {
                return;
            }

            if (l1 == null) {
                head.next = l2;
                return;
            }
            if (l2 == null) {
                head.next = l1;
                return;
            }
            int l1Value = l1.val;
            int l2Value = l2.val;
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            if (l1Value == l2Value) {
                l1.next = null;
                head.next = l1;
                head = head.next;
                l2.next = null;
                head.next = l2;
                mergeTwoListsHelper(l1Next, l2Next, head.next);
            }
            if (l1Value > l2Value) {
                l2.next = null;
                head.next = l2;
                mergeTwoListsHelper(l1, l2Next, head.next);
            }

            if (l1Value < l2Value) {

                l1.next = null;
                head.next = l1;
                mergeTwoListsHelper(l1Next, l2, head.next);
            }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode emptyNode = new ListNode(-1);
            mergeTwoListsHelper(l1, l2, emptyNode);
            return emptyNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode empty = new Solution().mergeTwoLists(l1, l2);
        while (empty != null) {
            System.out.print(empty.val + "->");
            empty = empty.next;
        }

    }
}
