package leet_code;

/**
 * Created by sanyinchen on 19-9-11.
 * <p>
 * from https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class Link_Solution_25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public ListNode reverseList(ListNode head, ListNode endNode) {
            ListNode emptyHeader = new ListNode(-1);
            ListNode temp;
            emptyHeader.next = endNode;
            while (head != null && head != endNode) {
                temp = head.next;
                head.next = emptyHeader.next;
                emptyHeader.next = head;
                head = temp;
            }
            return emptyHeader.next;

        }

        private int getLinkLength(ListNode head) {
            int i = 0;
            for (ListNode x = head; x != null; x = x.next) {
                i++;
            }
            return i;
        }

        // make sure head.length > k
        private ListNode getKIndexNode(ListNode head, int k) {
            int i = 0;
            ListNode node = head;
            while (head.val == -1) {
                head = head.next;
            }
            for (ListNode x = head; x != null && i < k; x = x.next) {
                i++;
                node = x;
            }

            return node;

        }


        public ListNode reverseKGroup(ListNode head, int k) {
            int length = getLinkLength(head);
            if (head == null || head.next == null || length < k) {
                return head;
            }

            ListNode kEndNode = getKIndexNode(head, k);

            ListNode headerEmptyNode = new ListNode(-1);
            headerEmptyNode.next = reverseList(head, kEndNode.next);

            for (ListNode x = headerEmptyNode.next; x != null; x = x.next) {
                System.out.print(x.val);
            }
            System.out.println();
            ListNode shortEnd = getKIndexNode(headerEmptyNode.next, k);

            ListNode shortHeader = reverseKGroup(shortEnd.next, k);
            shortEnd.next = shortHeader;

            return headerEmptyNode.next;
        }
    }

    public static ListNode createMockList() {
        ListNode header = new ListNode(1);
        header.next = new ListNode(2);
//        header.next.next = new ListNode(3);
//        header.next.next.next = new ListNode(4);
//        header.next.next.next.next = new ListNode(5);

        return header;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode header = createMockList();
        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
        System.out.println("");
        header = solution.reverseKGroup(header, 2);

        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
    }

}
