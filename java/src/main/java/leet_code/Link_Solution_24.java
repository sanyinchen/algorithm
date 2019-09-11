package leet_code;

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

        private ListNode nodeSwap(ListNode first, ListNode second) {
            if (first == null || second == null) {
                return first;
            }

            ListNode secondOldNext = second.next;
            second.next = first;
            first.next = secondOldNext;

            return second;
        }

        public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }
            ListNode oldHead = new ListNode(-1);
            oldHead.next = nodeSwap(head, head.next);
            ListNode preNode = head;
            for (ListNode index = head.next; index != null; index = index.next) {
                preNode.next = nodeSwap(index, index.next);
                preNode = index;
            }
            return oldHead.next;
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
