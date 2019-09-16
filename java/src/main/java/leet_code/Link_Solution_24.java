package leet_code;

import java.util.List;

/**
 * Created by sanyinchen on 19-9-11.
 * <p>
 * from https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class Link_Solution_24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private ListNode[] nodeSwap(ListNode first, ListNode second) {
            if (first == null || second == null) {
                return new ListNode[]{first, first};
            }

            ListNode secondOldNext = second.next;
            second.next = first;
            first.next = secondOldNext;

            return new ListNode[]{first, second};
        }

        public ListNode doSwapPairs(ListNode head, ListNode preNode) {
            if (head == null) {
                return null;
            }
            ListNode[] nodes = nodeSwap(head, head.next);
            preNode.next = nodes[1];
            return doSwapPairs(nodes[0].next, nodes[0]);
        }

        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode emptyNode = new ListNode(-1);
            doSwapPairs(head, emptyNode);
            return emptyNode.next;
        }
    }

    public static ListNode createMockList() {
        ListNode header = new ListNode(1);
        header.next = new ListNode(2);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(4);
        header.next.next.next.next = new ListNode(5);

        return header;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode header = createMockList();
        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
        System.out.println("");
        header = solution.swapPairs(header);

        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
    }

}
